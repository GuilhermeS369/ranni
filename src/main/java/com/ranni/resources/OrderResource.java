package com.ranni.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	public ResponseEntity<Order> findById(@PathVariable Long id) {

		Order obj = service.findById(id);

		return ResponseEntity.ok().body(obj);

	}

	// ----------------------------------------------------------------------------------------
	// OPERAÇÃO PARA INSERIR O USUARIO
	// METODO QUE RECEBE O POST DA URL E ENVIA PRO BD
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@PostMapping
	public ResponseEntity<Order> insert(@RequestBody Order obj) {
		obj = service.insert(obj);
		// VARIAVEL DO TIPO URI
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);

	}

	// ----------------------------------------------------------------------------------------
	// OPERAÇÃO PARA DELETAR O USUARIO
	// USAREMOS VOID POIS N RETORNARA NENHUM CORPO
	// PARA LONG ID SER RECONHECIDO COMO VARIAVEL NA URL, USAMOS PATH
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);

		return ResponseEntity.noContent().build();

	}

	// ----------------------------------------------------------------------------------------
	// OPERAÇÃO PARA ATUALIZAR O USUARIO
	// @PATHVARIABLE PARA PUXAR DA URL O ID
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
