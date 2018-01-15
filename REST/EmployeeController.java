package com.au.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.accolite.EmployeeForum.model.*;
import com.accolite.java.EmployeeForum.services.*;

@Path("employees")
public class EmployeeController {
	
	
	//everytime you hit an url,
	// a new controller object is created,
	// hence a new EmplyeeService is created,
	// hence make that as static too.
	
	static EmployeeServices serviceObject = new EmployeeServices();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployeeDetails(){
		
		//add logic needed
		
		return serviceObject.getAllEmployees();
		
	}
	
	
	
	//calling uri: http://localhost:8080/EmployeeForum/webapi/employees/1
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@PathParam("id") int id){
		//@QueryParam
		
		//add logic if needed
		
		return serviceObject.getEmployee(id);
		
	}
	
	
	@POST
	@Path("addEmployee")
	@Consumes({"application/xml", "application/json"})
	public String insertEmployee(Employee employee) {
		//use logging within controller functions- which is useful for debugging
		
		
		System.out.println("inserting a new employee");
		
		
		return serviceObject.insert(employee);
	}
	
	@POST
	@Path("updateEmployee/{param1}/{param2}")
	@Consumes({"application/xml", "application/json"})
	public String updateEmployee(@PathParam("param1") int id,@PathParam("param2") String name){
		//use logging within controller functions - which is useful for debugging
//		return id + name;
//		System.out.println("updating employee");
		return serviceObject.update(id, name);
	}
	
	
	
	@POST
	@Path("deleteEmployee/{empId}")
	public String deleteEmployee(@PathParam("empId") int id){
	//use logging within controller functions - which is useful for debugging
		
		return serviceObject.delete(id);
	}		

			
}
