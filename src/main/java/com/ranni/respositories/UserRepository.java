package com.ranni.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranni.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
