package com.hcl.demo.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.demo.dto.FundTransfer;
import com.hcl.demo.dto.User;
import com.hcl.demo.dto.UserCred;
import com.hcl.demo.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/fund")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "create User", notes = "Create user account")
	@PostMapping("createUser")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		logger.info("create User invoked");
		User saveUser = userService.saveUser(user);
		return new ResponseEntity<User>(saveUser, HttpStatus.OK);
	}
	

	@ApiOperation(value = "get User Account", notes = "Get User account by cred")
	@PostMapping("/getUser")
	public ResponseEntity<User> getUser(@ApiParam(name = "usercred", required = true) @RequestBody @Valid UserCred userCred){
		logger.info("Get user for name: {} and password: {}",userCred.getName(),userCred.getPassword());
		User user = userService.getUser(userCred.getName(), userCred.getPassword());
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping("/addAmount")
	public ResponseEntity<User> addAmount(@ApiParam(name="Amount to be added",required = true) @RequestBody @Valid UserCred userCred){
		logger.info("add amount method invoked.");
		User user = userService.addAmount(userCred.getName(), userCred.getPassword(), userCred.getAmount());
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping("/fundTransfer")
	public ResponseEntity<String> transfterAmount(@ApiParam(name="Amount to be transffed",required = true) @RequestBody @Valid FundTransfer fund){
		logger.info("add amount method invoked.");
		userService.transferFund(fund.getFromAccount(), fund.getToAccount(), fund.getAmount());
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}

}
