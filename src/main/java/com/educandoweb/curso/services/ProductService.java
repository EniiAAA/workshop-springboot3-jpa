package com.educandoweb.curso.services;

import com.educandoweb.curso.entities.Product;
import com.educandoweb.curso.repositories.ProductRepository;
import com.educandoweb.curso.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }

    public Product createProduct(Product product) {
        // Salvar o produto
        Product savedProduct = repository.save(product);
        return savedProduct;
    }

    public void deleteProduct(Long productId) {
        // Verificar se o produto existe antes de excluí-lo
        if (!repository.existsById(productId)) {
            throw new ResourceNotFoundException("Produto não encontrado");
        }
        // Excluir o produto
        repository.deleteById(productId);
    }
}
