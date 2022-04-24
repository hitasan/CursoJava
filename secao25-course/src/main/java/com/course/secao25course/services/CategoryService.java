package com.course.secao25course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.secao25course.entities.Category;
import com.course.secao25course.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	// Metodo para listagem de todos usuarios
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	// Metodo para listagem do usuario especificado pelo id recebido
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();	// Retorna o objeto Category que esta no obj Optional
	}
}
