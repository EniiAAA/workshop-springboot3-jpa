package com.educandoweb.curso.repositories;

import com.educandoweb.curso.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	
}
