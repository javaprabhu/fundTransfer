package com.hcl.demo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class UserCred {
	@NotBlank(message = "Name is mandatory")
	private String name;
	@NotBlank(message = "password is mandatory")
	private String password;
	
	@Min(value = 1000, message = "min 1000")
	private Integer amount;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
}
