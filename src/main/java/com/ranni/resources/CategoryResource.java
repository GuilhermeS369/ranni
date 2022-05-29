package com.ranni.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ranni.entities.Category;
import com.ranni.services.CategoryService;

//DIZ QUE É UM RECURSO WEB @RestController
@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	// DEPENDENCIA PARA CAMADA SERVICELAYER
	@Autowired
	private CategoryService service;

	// ENDPOINT PARA ACESSAR OS USUARIOS
	// INDICA QUE O METODO RESPONDE A UMA REQUESIÇÃO
	// DO TIPO HTTP = @GETMAPPING
	@GetMapping
	// REPONSEENTITY RETORNA REQUISIÇÕES WEB RECEBENDO SEU TIPO
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();
		// RESPONDE OK, E TRAZ COMO RESPOSTA UMA LISTA
		return ResponseEntity.ok().body(list);
	}

	// ----------------------------------------------------------------------------------------
	// ENDPOINT DO CONTROLADORREST
	@GetMapping(value = "/{id}")
	
	public ResponseEntity <Category> findById(@PathVariable Long id) {
	
		Category obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
		
	}

}
