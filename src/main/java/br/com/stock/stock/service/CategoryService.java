package br.com.stock.stock.service;

import br.com.stock.stock.model.Category;
import br.com.stock.stock.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public record CategoryService(CategoryRepository categoryRepository) {

    public void save(Category category){
        categoryRepository.save(category);
    }
    public Optional<Category> findById(Long id){
        return categoryRepository.findById(id);
    }
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public void deleteById(Long id){
        categoryRepository.deleteById(id);
    }
}
