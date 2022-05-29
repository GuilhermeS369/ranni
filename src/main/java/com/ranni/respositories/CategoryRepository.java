package com.ranni.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranni.entities.Category;

//OPICIONAL
//@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
