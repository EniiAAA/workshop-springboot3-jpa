package com.educandoweb.curso.repositories;

import com.educandoweb.curso.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	
}
