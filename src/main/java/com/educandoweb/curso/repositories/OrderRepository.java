package com.educandoweb.curso.repositories;

import com.educandoweb.curso.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>{

	
}
