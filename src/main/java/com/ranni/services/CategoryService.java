package com.ranni.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranni.entities.Category;
import com.ranni.respositories.CategoryRepository;

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
	
	
}
