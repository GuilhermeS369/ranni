package com.ranni.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranni.entities.Order;

//OPICIONAL
//@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
