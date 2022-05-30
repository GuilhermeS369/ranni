package com.ranni.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranni.entities.OrderItem;

//OPICIONAL
//@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
