package com.ranni.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ranni.entities.Category;
import com.ranni.entities.Product;
import com.ranni.respositories.ProductRepository;
import com.ranni.services.exceptions.DatabaseException;
import com.ranni.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	@Autowired
	private CategoryService category;

	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product findById(Long id) {
		// TIPO OPTIONAL ARMAZENA O OBJ
		Optional<Product> obj = repository.findById(id);
		// RETORNA O OBJ
		return obj.get();
	}

	public Product insert(Product obj) {
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

	public Product update(Long id, Product obj) {

		try {
			// PREPARA PARA RECEBER UM TIPO
			Product entity = repository.getReferenceById(id);
			// ATUALIZA A ENTITY COM OS DADOS DO OBJ
			updateData(entity, obj);
			// SALVA A ENTITY
			return repository.save(entity);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}

	}
	// METODO PARA VINCULAR CATEGORIA A UM PRODUTO
	public Category updateCat(Long id, Long idCat) {

		try {
			// PREPARA PARA RECEBER UM TIPO
			Product entity = repository.getReferenceById(id);
			// ATUALIZA A ENTITY COM OS DADOS DO OBJ
			updateCategories(entity, idCat);
			// SALVA A ENTITY
			repository.save(entity);
			return category.findById(idCat);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}

	}
	
	//METODO ONDE VC SELECIONA OQ QUER DAR UPDATE
		private void updateData(Product entity, Product obj) {
			entity.setName(obj.getName());
			entity.setDescription(obj.getDescription());
			entity.setImgUrl(obj.getImgUrl());
			entity.setPrice(obj.getPrice());
			
		
		}
		private void updateCategories(Product entity, Long idCat) {
			entity.getCategories().add(category.findById(idCat));
		}

}
