package com.ranni.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranni.entities.Product;

//OPICIONAL
//@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
