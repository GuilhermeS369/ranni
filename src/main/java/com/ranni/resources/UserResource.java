package com.ranni.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ranni.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	//ENDPOINT PARA ACESSAR OS USUARIOS
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Alice", "Alice@gmail.com", "1188888888", "123456789");
		//RESPONDE OK, E TRAZ COMO RESPOSTA O CORPO DA ENTIDADE "U"
		return ResponseEntity.ok().body(u);
		
	}
}
