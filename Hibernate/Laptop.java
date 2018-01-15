package com.au.hibernet.Assignment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Laptop {
	@Id 
	private int Lid;			//primary key
	private String Brand;
	private String Price;
	
	
	public int getLid() {
		return Lid;
	}
	public void setLid(int lid) {
		Lid = lid;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}

}
