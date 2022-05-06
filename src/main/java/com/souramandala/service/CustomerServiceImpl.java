package com.souramandala.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souramandala.entity.Customer;

import com.souramandala.exception.CustomerException;
import com.souramandala.repo.CustomerRepo;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public String createUser(Customer customer) throws CustomerException {
		customerRepo.save(customer);
		return "User Created Successfully";
	}

	@Override
	public Customer getCustomerById(int custId) throws CustomerException {
		Customer resultCust= customerRepo.findBycustId(custId);
		if(resultCust!=null) {
			return resultCust;
		}else {
			throw new CustomerException("No user found with that customer Id");
		}
	}

	@Override
	public Customer getCustomerByUsernameAndPassword(String userName, String password) throws CustomerException {
		Customer customer = customerRepo.findByuserNameAndPassword(userName, password);
		if(customer!=null) {
			return customer;
		}else {
			throw new CustomerException("Wrong User Credentials");
		}
	}

	@Override
	public Customer updateCustomerDetails(Customer customer) throws CustomerException {
		int custId = customer.getCustId();
		Customer updatedCustomer=null;
		Customer resCustomer = customerRepo.findBycustId(custId);
		if(resCustomer!=null) {
			updatedCustomer = customerRepo.save(customer);
		}else {
			throw new CustomerException("No User with the custId");
		}
		return updatedCustomer;
	}

	@Override
	public String deleteCustomerById(int custId) throws CustomerException {
		Customer customer = customerRepo.findBycustId(custId);
		if(customer!=null) {
			customerRepo.delete(customer);
		}else {
			throw new CustomerException("No Customer with that Id");
		}
		
		return "User Deleted Successfully";
	}

	/*
	 * @Override public Iterable<OrderEntity> getOrdersOfCustByCustId(int custId)
	 * throws CustomerException { Iterable<OrderEntity> resultList =
	 * customerRepo.getOrdersByCustId(custId); if(resultList!=null) { return
	 * resultList; }else { throw new
	 * CustomerException("No orders placed by the customer"); } }
	 */

}
