package br.com.stock.stock.controllers;

import br.com.stock.stock.model.Product;
import br.com.stock.stock.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping({"/stock"})
public record ProductController(ProductService productService) {

    @PostMapping({"/product"})
    public ResponseEntity<String> saveProduct(@RequestBody Product product){
        productService.save(product);
        return ResponseEntity.ok("Product saved successfully");
    }

    @GetMapping({"/product/{id}"})
    public ResponseEntity<Product> findProductById(@PathVariable Long id){
        Optional<Product> productOptional = productService.findById(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            return ResponseEntity.ok().body(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping({"/product/{id}"})
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productService.deleteById(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
}