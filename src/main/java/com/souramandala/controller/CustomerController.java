package com.souramandala.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.souramandala.entity.Customer;
import com.souramandala.entity.OrderEntity;
import com.souramandala.service.CustomerService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	

	@PostMapping(value = "/customer", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createCustomer(@RequestBody Customer customer) {
		return customerService.createUser(customer);
	}

	@GetMapping(value = "/customer/{custId}")
	public Customer getCustomerById(@PathVariable int custId) {

		return customerService.getCustomerById(custId);

	}

	@GetMapping(value = "/getcustomerbynameandpass/{userName}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomerByUsernameAndPassword(@PathVariable String userName, @PathVariable String password) {
		return customerService.getCustomerByUsernameAndPassword(userName, password);
	}

	@PutMapping(value = "/updatecustomer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomerDetails(customer);
	}

	@DeleteMapping(value = "/deletevaluebyid/{custId}")
	public String deleteCustomerById(@PathVariable int custId) {
		return customerService.deleteCustomerById(custId);
	}

	@GetMapping(value = "/getordersofcust/{custId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<OrderEntity> getOrdersOfCustByCustId(int custId) {
		return customerService.getOrdersOfCustByCustId(custId);
	}

	@GetMapping(value = "/validateorders/{custId}")
	public String validateOrdersOfCustomer(int custId) {
		return customerService.validateTheOrdersOfCustomer(custId);
	}
	
	

}
