package com.ranni.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ranni.entities.Order;
import com.ranni.respositories.OrderRepository;
import com.ranni.services.exceptions.DatabaseException;
import com.ranni.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;

	public List<Order> findAll() {
		return repository.findAll();
	}

	public Order findById(Long id) {
		// TIPO OPTIONAL ARMAZENA O OBJ
		Optional<Order> obj = repository.findById(id);
		// RETORNA O OBJ
		return obj.get();
	}

	public Order insert(Order obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);

		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());

		}
	}

	// GETBYID E GET ONE DESCONTINUADO, SUBSTITUIDO GETREFERENCEBYID
	// METODO QUE PUXA O OBJ DO ID E ENVIA JUNTO COM OBJ DO METODO
	public Order update(Long id, Order obj) {

		try {
			// PREPARA PARA RECEBER UM TIPO
			Order entity = repository.getReferenceById(id);
			// ATUALIZA A ENTITY COM OS DADOS DO OBJ
			updateData(entity, obj);
			// SALVA A ENTITY
			return repository.save(entity);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}

	}

	// METODO ONDE VC SELECIONA OQ QUER DAR UPDATE
	private void updateData(Order entity, Order obj) {
		entity.setClient(obj.getClient());
		entity.setMoment(obj.getMoment());
		entity.setOrderStatus(obj.getOrderStatus());
		entity.setPayment(obj.getPayment());

	}

}
