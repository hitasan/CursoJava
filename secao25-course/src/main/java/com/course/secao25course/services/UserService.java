package com.course.secao25course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.course.secao25course.entities.User;
import com.course.secao25course.repositories.UserRepository;
import com.course.secao25course.services.exceptions.DatabaseException;
import com.course.secao25course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	// Metodo para listagem de todos usuarios
	public List<User> findAll() {
		return repository.findAll();
	}
	
	// Metodo para listagem do usuario especificado pelo id recebido
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));	// Retorna o objeto User que esta no obj Optional
	}

	// Metodo para INSERIR um novo registro conforme obj recebido por parametro 
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	// Metodo para ALTERAR um registro existente conforme Id recebido para localização e Obj User com novos dados
	public User update(Long id, User obj) {
		try {
			User entity = repository.getById(id);
			entity.setNome(obj.getNome());
			entity.setEmail(obj.getEmail());
			entity.setPhone(obj.getPhone());
			
			return repository.save(entity);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}

	}

	// Metodo para DELETAR um registro conforme ID recebido por parametro 
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}
