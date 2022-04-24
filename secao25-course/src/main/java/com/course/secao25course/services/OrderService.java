package com.course.secao25course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.secao25course.entities.Order;
import com.course.secao25course.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	// Metodo para listagem de todos pedidos
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	// Metodo para listagem do pedido especificado pelo id recebido
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();	// Retorna o objeto Order que esta no obj Optional
	}
}
