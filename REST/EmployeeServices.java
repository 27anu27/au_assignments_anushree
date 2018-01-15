package com.au.rest;
import java.util.*;
import com.accolite.EmployeeForum.model.*;

public class EmployeeServices {
	
	static List<Employee> employeeList = new ArrayList<Employee>();
	
	public EmployeeServices() {
		Employee n = new Employee();
		n.setId(1);
		n.setName("Anushree");
		
		employeeList.add(n);
		
	}

	public List<Employee> getAllEmployees(){
		return employeeList;
	}
	
	
	public Employee getEmployee(int id){
		
		for(Employee e: employeeList ) {
			if(e.getId() == id) {
				return e;
			}
		}
		
		return null;
	}
	

	public String insert(Employee employee){
		
		int id = employee.getId();
		for(Employee e: employeeList) {
			if(e.getId() == id){
				return "An Employee with id:" + id + " already Exists!Please Retry with another ID";
			}
		}
		
		employeeList.add(employee);
		return "Successfully inserted employee with id:" + employee.getId();	
	}


	public String update(int id, String name) {
		
		for(Employee e: employeeList){
			if(e.getId() == id){
				
				e.setName(name);
				return "Updated name successfully";
			}
		}
		
		return "Update Unsuccessfull!!\n There is n employee with ID:" + id;
	}


	public String delete(int id) {
		
		
		Iterator<Employee> iterator = employeeList.iterator();
		
		while(iterator.hasNext())
		{
		    Employee e = iterator.next();
		    if (e.getId() == id)
		    {
		        iterator.remove();
		        return "Successfully deleted employee with id:" + id;
		    }
		}
		return "No record found with ID: " + id;
	}
	
	
}
