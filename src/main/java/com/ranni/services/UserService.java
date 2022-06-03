package com.ranni.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranni.entities.User;
import com.ranni.respositories.UserRepository;
import com.ranni.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	// METODO QUE PUXA O OBJ DO ID E ENVIA JUNTO COM OBJ DO METODO
	public User update(Long id, User obj) {
		// PREPARA PARA RECEBER UM TIPO
		User entity = repository.getOne(id);
		// ATUALIZA A ENTITY COM OS DADOS DO OBJ
		updateData(entity, obj);
		// SALVA A ENTITY 
		return repository.save(entity);
	}
	//METODO ONDE VC SELECIONA OQ QUER DAR UPDATE
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
		
}
