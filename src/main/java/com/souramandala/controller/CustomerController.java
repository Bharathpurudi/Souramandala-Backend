package com.souramandala.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

import com.souramandala.entity.Constants;
import com.souramandala.entity.Customer;
import com.souramandala.service.CustomerService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

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

	@PostMapping(value="/customer/authenticate") public Map<String,String>
	  generateToken(@RequestBody Customer customer){ 
		long timestamp =System.currentTimeMillis(); 
		String token = Jwts.builder().signWith(SignatureAlgorithm.HS256,Constants.API_SECRET_KEY)
				.setIssuedAt(new Date(timestamp))
				.setExpiration(new Date(timestamp+Constants.TOKEN_VALIDITY))
				.claim("userId",customer.getCustId())
				.claim("userName",customer.getUserName())
				.claim("email", customer.getMailId())
				.compact();
		Map<String,String> map=new HashMap<>();
		map.put("JWT", token);
		return map;
						
	  }

	@GetMapping(value = "/customer/{custId}")
	public Customer getCustomerById(@PathVariable int custId) {

		return customerService.getCustomerById(custId);

	}

	@GetMapping(value = "/customer/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomerByUsername(@PathVariable String userName) {
		return customerService.getCustomerByUsername(userName);
	}

	@PutMapping(value = "/customer/updatecustomer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomerDetails(customer);
	}

	@DeleteMapping(value = "/customer/deletebyid/{custId}")
	public String deleteCustomerById(@PathVariable int custId) {
		return customerService.deleteCustomerById(custId);
	}
	
	@PutMapping(value="/customer/updateFeilds/{firstName}/{lastName}/{password}/{mobNum}/{mailId}/{custId}")
	public Customer updateTheFeildsOfCust(@PathVariable String firstName,@PathVariable String lastName,@PathVariable String password,@PathVariable String mobNum,@PathVariable String mailId,@PathVariable int custId) {
		return customerService.updateFeildsOfCustomer(firstName, lastName, password, mobNum, mailId,custId);
	}
	

	/*
	 * @GetMapping(value = "/getordersofcust/{custId}", produces =
	 * MediaType.APPLICATION_JSON_VALUE) public Set<OrderEntity>
	 * getOrdersOfCustByCustId(int custId) { return
	 * customerService.getOrdersOfCustByCustId(custId); }
	 */

	/*
	 * @GetMapping(value = "/customer/validateorders/{custId}") public String
	 * validateOrdersOfCustomer(int custId) { return
	 * customerService.validateTheOrdersOfCustomer(custId); }
	 */

}
