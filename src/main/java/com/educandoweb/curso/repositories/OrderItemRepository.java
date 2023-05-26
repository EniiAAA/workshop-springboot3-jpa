package com.educandoweb.curso.repositories;

import com.educandoweb.curso.entities.OrderItem;
import com.educandoweb.curso.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

    @Query("SELECT oi FROM OrderItem oi WHERE oi.id.product = :product")
    List<OrderItem> findByProduct(@Param("product") Product product);
	
}
