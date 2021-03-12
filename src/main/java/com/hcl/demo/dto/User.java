package com.hcl.demo.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 20)
	@NotBlank(message = "Name is mandatory")
	private String name;
	@NotBlank(message = "password is mandatory")
	@Size(min = 6,max=8)
	private String password;
	@NotNull(message = "dob cannot be null")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;
	@NotBlank(message = "address is mandatory")
	@Column(length = 50)
	private String address;
	@NotBlank(message = "Adhar No is mandatory")
	@Column(length = 10)
	private String adharId;
	
	@Column(unique = true)
	private String accountNo;
	@Min(value = 100, message = "value should be greater than 100.")
	private Integer amount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAdharId() {
		return adharId;
	}

	public void setAdharId(String adharId) {
		this.adharId = adharId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", dob=" + dob + ", address=" + address
				+ ", adharId=" + adharId + ", accountNo=" + accountNo + ", amount=" + amount + "]";
	}
	
	
}
