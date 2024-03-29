package com.ranni.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ranni.entities.User;
import com.ranni.respositories.UserRepository;
import com.ranni.services.exceptions.DatabaseException;
import com.ranni.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	@Autowired
	private PasswordEncoder encoder;

	public UserService() {
	}

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

		String pass = obj.getPassword();
		//criptografando antes de salvar no banco
		obj.setPassword(encoder.encode(pass));

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
	public User update(Long id, User obj) {

		try {
		// PREPARA PARA RECEBER UM TIPO
		User entity = repository.getReferenceById(id);
		// ATUALIZA A ENTITY COM OS DADOS DO OBJ
		updateData(entity, obj);
		// SALVA A ENTITY 
		return repository.save(entity);
		
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}

	}
	//METODO ONDE VC SELECIONA OQ QUER DAR UPDATE
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
		
}
