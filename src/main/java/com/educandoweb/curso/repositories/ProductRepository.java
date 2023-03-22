package com.educandoweb.curso.repositories;

import com.educandoweb.curso.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{

	
}
