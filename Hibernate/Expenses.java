package com.au.hibernet.Assignment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Expenses {
	
	@Id
	private int Exid;
	private int amount;
	
	
	public int getExid() {
		return Exid;
	}
	public void setExid(int exid) {
		Exid = exid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
