package com.educandoweb.curso.resources;

import com.educandoweb.curso.entities.OrderItem;
import com.educandoweb.curso.entities.Product;
import com.educandoweb.curso.repositories.OrderItemRepository;
import com.educandoweb.curso.repositories.ProductRepository;
import com.educandoweb.curso.services.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	@Autowired
	private ProductService service;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}


	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product savedProduct = service.createProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));

		// Verificar se existem OrderItems associados ao produto
		List<OrderItem> orderItems = orderItemRepository.findByProduct(product);
		if (!orderItems.isEmpty()) {
			// Retornar uma resposta indicando que a exclusão não é permitida devido à dependência
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		// Excluir o produto
		productRepository.delete(product);

		return ResponseEntity.noContent().build();
	}
}
