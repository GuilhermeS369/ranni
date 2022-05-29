package com.ranni.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranni.entities.Product;
import com.ranni.respositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		//TIPO OPTIONAL ARMAZENA O OBJ
		Optional<Product> obj = repository.findById(id);
		//RETORNA O OBJ
		return obj.get();
	}
	
	
}
