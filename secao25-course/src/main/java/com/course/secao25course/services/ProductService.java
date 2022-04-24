package com.course.secao25course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.secao25course.entities.Product;
import com.course.secao25course.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	// Metodo para listagem de todos usuarios
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	// Metodo para listagem do usuario especificado pelo id recebido
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();	// Retorna o objeto Product que esta no obj Optional
	}
}
