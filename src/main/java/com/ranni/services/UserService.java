package com.ranni.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranni.entities.User;
import com.ranni.respositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		//TIPO OPTIONAL ARMAZENA O OBJ
		Optional<User> obj = repository.findById(id);
		//RETORNA O OBJ
		return obj.get();
	}
	
	
}
