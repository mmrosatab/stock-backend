package br.com.stock.stock.repository;

import br.com.stock.stock.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}