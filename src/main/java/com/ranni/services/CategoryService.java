package com.ranni.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ranni.entities.Category;
import com.ranni.respositories.CategoryRepository;
import com.ranni.services.exceptions.DatabaseException;
import com.ranni.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		//TIPO OPTIONAL ARMAZENA O OBJ
		Optional<Category> obj = repository.findById(id);
		//RETORNA O OBJ
		return obj.get();
	}
	public Category insert(Category obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
		repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
			
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
			
		}
	}
	//GETBYID E GET ONE DESCONTINUADO, SUBSTITUIDO GETREFERENCEBYID
	// METODO QUE PUXA O OBJ DO ID E ENVIA JUNTO COM OBJ DO METODO
	public Category update(Long id, Category obj) {
		
		
		
		try {
		// PREPARA PARA RECEBER UM TIPO
		Category entity = repository.getReferenceById(id);
		// ATUALIZA A ENTITY COM OS DADOS DO OBJ
		updateData(entity, obj);
		// SALVA A ENTITY 
		return repository.save(entity);
		
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
		
		
		
	}
	//METODO ONDE VC SELECIONA OQ QUER DAR UPDATE
	private void updateData(Category entity, Category obj) {
		entity.setName(obj.getName());
	
	}
	
}
