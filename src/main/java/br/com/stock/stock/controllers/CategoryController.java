package br.com.stock.stock.controllers;

import br.com.stock.stock.model.Category;
import br.com.stock.stock.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping({"/stock"})
public record CategoryController(CategoryService categoryService) {
    @PostMapping({"/category"})
    public ResponseEntity<String> saveCategory(@RequestBody Category category){
        categoryService.save(category);
        return ResponseEntity.ok("Product saved successfully");
    }

    @GetMapping({"/category/{id}"})
    public ResponseEntity<Category> findCategoryById(@PathVariable Long id){
        Optional<Category> categoryOptional = categoryService.findById(id);

        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            return ResponseEntity.ok().body(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping({"/category/{id}"})
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        categoryService.deleteById(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
}
