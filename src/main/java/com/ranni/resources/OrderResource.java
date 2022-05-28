package com.ranni.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ranni.entities.Order;
import com.ranni.services.OrderService;

//DIZ QUE É UM RECURSO WEB @RestController
@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	// DEPENDENCIA PARA CAMADA SERVICELAYER
	@Autowired
	private OrderService service;

	// ENDPOINT PARA ACESSAR OS USUARIOS
	// INDICA QUE O METODO RESPONDE A UMA REQUESIÇÃO
	// DO TIPO HTTP = @GETMAPPING
	@GetMapping
	// REPONSEENTITY RETORNA REQUISIÇÕES WEB RECEBENDO SEU TIPO
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();
		// RESPONDE OK, E TRAZ COMO RESPOSTA UMA LISTA
		return ResponseEntity.ok().body(list);
	}

	// ----------------------------------------------------------------------------------------
	// ENDPOINT DO CONTROLADORREST
	@GetMapping(value = "/{id}")
	
	public ResponseEntity <Order> findById(@PathVariable Long id) {
	
		Order obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
		
	}

}
