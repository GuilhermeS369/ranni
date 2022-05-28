package com.ranni.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranni.entities.Order;
import com.ranni.respositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		//TIPO OPTIONAL ARMAZENA O OBJ
		Optional<Order> obj = repository.findById(id);
		//RETORNA O OBJ
		return obj.get();
	}
	
	
}
