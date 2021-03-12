package com.hcl.demo.service;

import com.hcl.demo.dto.User;

public interface UserService {

	User saveUser(User user);
	User getUser(String name, String password);
	Integer transferFund(String fromAccount, String toAccount, Integer amount);
	User addAmount(String name, String password, Integer amount);
}
