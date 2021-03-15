package com.hcl.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.demo.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByNameAndPassword(String name, String password);
	User findByAccountNo(String accountNo);
	User findByAdharId(String adharId);
}
