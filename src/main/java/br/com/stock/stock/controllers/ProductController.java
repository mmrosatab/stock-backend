package br.com.stock.stock.controllers;

import br.com.stock.stock.model.Category;
import br.com.stock.stock.model.Product;
import br.com.stock.stock.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.logging.Logger;

@RestController
@RequestMapping({"/stock"})
public record ProductController(ProductService productService) {

    @PostMapping({"/product"})
    public ResponseEntity<String> saveProduct(@RequestBody Product product){
        Logger logger = Logger.getLogger(ProductController.class.getName());
        logger.warning(product.getCategory().getId().toString());
        productService.save(product);
        return ResponseEntity.ok("Product saved successfully");
    }

//    @GetMapping({"/product"})
//    public ResponseEntity<Product> getProducts(){
//        List<Product> productOptional = productService.findAll();
//
//        if (productOptional.isPresent()) {
//            Product product = productOptional.get();
//            return ResponseEntity.ok().body(product);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
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