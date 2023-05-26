package com.educandoweb.curso.services;

import com.educandoweb.curso.entities.Order;
import com.educandoweb.curso.repositories.OrderRepository;
import com.educandoweb.curso.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }

    public Order createOrder(Order order) {
        // Salvar o pedido
        Order savedOrder = repository.save(order);

        return savedOrder;
    }

    public void deleteOrder(Long orderId) {
        // Verificar se o pedido existe antes de excluí-lo
        if (!repository.existsById(orderId)) {
            throw new ResourceNotFoundException("Pedido não encontrado");
        }
        // Excluir o pedido
        repository.deleteById(orderId);
    }
}
