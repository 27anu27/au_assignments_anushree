package com.au.hibernet.Assignment;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Employee {
	
	@Id
	private int Eid;			//primary key
	private String Name;
	private int Salary;
	
	@OneToOne				//relation
	private Laptop laptop;
	
	@OneToMany				//relation
	private List<Expenses> expenses = new ArrayList<Expenses>();
	
	
	public List<Expenses> getExpenses() {
		return expenses;
	}
	public void setExpenses(List<Expenses> expenses) {
		this.expenses = expenses;
	}
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	public int getEid() {
		return Eid;
	}
	public void setEid(int eid) {
		Eid = eid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	

}
