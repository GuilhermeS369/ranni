package com.ranni.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ranni.entities.User;
import com.ranni.services.UserService;

//DIZ QUE É UM RECURSO WEB @RestController
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	// DEPENDENCIA PARA CAMADA SERVICELAYER
	@Autowired
	private UserService service;
	// ----------------------------------------------------------------------------------------
	// ENDPOINT PARA ACESSAR OS USUARIOS
	// INDICA QUE O METODO RESPONDE A UMA REQUESIÇÃO
	// DO TIPO HTTP = @GETMAPPING
	@GetMapping
	// REPONSEENTITY RETORNA REQUISIÇÕES WEB RECEBENDO SEU TIPO
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		// RESPONDE OK, E TRAZ COMO RESPOSTA UMA LISTA
		return ResponseEntity.ok().body(list);
	}

	// ----------------------------------------------------------------------------------------
	// ENDPOINT DO CONTROLADORREST
	// CAMINHO PARA ACESSAR:
	@GetMapping(value = "/{id}")
	// PARA LONG ID SER RECONHECIDO COMO VARIAVEL NA URL, USAMOS PATH
	public ResponseEntity<User> findById(@PathVariable Long id) {

		User obj = service.findById(id);

		return ResponseEntity.ok().body(obj);

	}

	// ----------------------------------------------------------------------------------------
	// OPERAÇÃO PARA INSERIR O USUARIO
	// METODO QUE RECEBE O POST DA URL E ENVIA PRO BD
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		// VARIAVEL DO TIPO URI
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
		
	}
	
	// ----------------------------------------------------------------------------------------
	// OPERAÇÃO PARA DELETAR O USUARIO
	// USAREMOS VOID POIS N RETORNARA NENHUM CORPO
	// PARA LONG ID SER RECONHECIDO COMO VARIAVEL NA URL, USAMOS PATH
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
		
	}
	
	// ----------------------------------------------------------------------------------------
	// OPERAÇÃO PARA ATUALIZAR O USUARIO
	// @PATHVARIABLE PARA PUXAR DA URL O ID
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update (@PathVariable Long id, @RequestBody User obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}





































