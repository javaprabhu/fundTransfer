package com.hcl.demo.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.demo.dto.User;
import com.hcl.demo.exception.CustomException;
import com.hcl.demo.repo.UserRepository;
import com.hcl.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User saveUser(User user) {
		logger.info("User is being save. -"+user);
		return userRepo.save(user);
	}

	@Override
	public User getUser(String name, String password) {
		logger.info("Get user by name {1} and password {2}",name, password);
		User user = userRepo.findByNameAndPassword(name, password);
		if(null==null) {
			throw new CustomException(400, "username or password is invalid");
		}
		return user;
	}

	@Override
	@Transactional
	public Integer transferFund(String fromAccount, String toAccount, Integer amount) {
		User fromUser = userRepo.findByAccountNo(fromAccount);
		User toUser = userRepo.findByAccountNo(toAccount);
		if(null==fromUser && null==toUser) {
			throw new CustomException(400, "please enter valid account.");
		}
		if(fromUser.getAmount()<amount) {
			throw new CustomException(500, "Not suffiencient amount to transfer");
		}
		fromUser.setAmount(fromUser.getAmount()-amount);
		toUser.setAmount(toUser.getAmount()+amount);
		userRepo.save(fromUser);
		userRepo.save(toUser);
		logger.info("amount {} transfered successfully.",amount);
		return null;
	}

	@Override
	public User addAmount(String name, String password, Integer amount) {
		logger.info("amount {} is being added to user {}",amount, name);
		User user = getUser(name, password);
		user.setAmount(user.getAmount()+amount);
		return userRepo.save(user);
	}

}
