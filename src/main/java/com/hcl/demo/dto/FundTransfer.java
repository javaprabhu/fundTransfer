package com.hcl.demo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class FundTransfer {

	@NotBlank(message = "from account cannot be blank.")
	private String fromAccount;

	@NotBlank(message = "to account cannot be blank.")
	private String toAccount;
	
	@Min(value = 100,message = "min 100")
	private Integer amount;

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
	
}
