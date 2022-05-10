package com.souramandala.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.souramandala.entity.Cart;
import com.souramandala.entity.Customer;
import com.souramandala.entity.OrderEntity;
import com.souramandala.service.CartServiceImpl;
import com.souramandala.service.CustomerServiceImpl;

@RestController
@RequestMapping(value = "/souramandala")
public class CustomerController {
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	@Autowired
	private CartServiceImpl cartServiceImpl;

	@PostMapping(value = "/createcustomer", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createCustomer(@RequestBody Customer customer) {
		return customerServiceImpl.createUser(customer);
	}

	@GetMapping(value = "/getcustomerbyid/{custId}")
	public Customer getCustomerById(@PathVariable int custId) {

		return customerServiceImpl.getCustomerById(custId);

	}

	@GetMapping(value = "/getcustomerbynameandpass/{userName}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomerByUsernameAndPassword(@PathVariable String userName, @PathVariable String password) {
		return customerServiceImpl.getCustomerByUsernameAndPassword(userName, password);
	}

	@PutMapping(value = "/updatecustomer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerServiceImpl.updateCustomerDetails(customer);
	}

	@DeleteMapping(value = "/deletevaluebyid/{custId}")
	public String deleteCustomerById(@PathVariable int custId) {
		return customerServiceImpl.deleteCustomerById(custId);
	}

	@GetMapping(value = "/getordersofcust/{custId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<OrderEntity> getOrdersOfCustByCustId(int custId) {
		return customerServiceImpl.getOrdersOfCustByCustId(custId);
	}

	@GetMapping(value = "/validateorders/{custId}")
	public String validateOrdersOfCustomer(int custId) {
		return customerServiceImpl.validateTheOrdersOfCustomer(custId);
	}
	
	@PostMapping(value="createcartofcustomer/{custId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Cart postThecartOfCustomer(int custId) {
		return cartServiceImpl.checkoutCart(custId);
	}

}
