package com.souramandala.service;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souramandala.entity.Customer;
import com.souramandala.exception.CustomerException;
import com.souramandala.repo.CustomerRepo;

@Service
@Transactional
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
		Customer resultCust = customerRepo.findBycustId(custId);
		if (resultCust != null) {
			return resultCust;
		} else {
			throw new CustomerException("No user found with that customer Id");
		}
	}

	@Override
	public Customer getCustomerByUsername(String userName) throws CustomerException {
		Customer customer = customerRepo.findByuserName(userName);
		if (customer != null) {
			return customer;
		} else {
			throw new CustomerException("Wrong User Credentials");
		}
	}

	@Override
	public Customer updateCustomerDetails(Customer customer) throws CustomerException {
		int custId = customer.getCustId();
		Customer updatedCustomer = null;
		Customer resCustomer = customerRepo.findBycustId(custId);
		if (resCustomer != null) {
			updatedCustomer = customerRepo.save(customer);
		} else {
			throw new CustomerException("No User with the custId");
		}
		return updatedCustomer;
	}

	@Override
	public String deleteCustomerById(int custId) throws CustomerException {
		Customer customer = customerRepo.findBycustId(custId);
		if (customer != null) {
			customerRepo.delete(customer);
		} else {
			throw new CustomerException("No Customer with that Id");
		}

		return "User Deleted Successfully";
	}

	@Override
	public Customer updateFeildsOfCustomer(String firstName, String lastName, String password, String mobNum,
			String mailId, int custId) {
		customerRepo.updateCustomerDetails(firstName, lastName, password, mobNum, mailId,custId);
		return customerRepo.findBycustId(custId);
	}

	/*
	 * @Override public Set<OrderEntity> getOrdersOfCustByCustId(int custId) throws
	 * CustomerException { Set<OrderEntity> orders =
	 * customerRepo.findBycustId(custId).getOrders(); if (orders != null) { return
	 * orders; } else { throw new
	 * CustomerException("No orders placed by that customer"); } }
	 */

	/*
	 * @Override public String validateTheOrdersOfCustomer(int custId) throws
	 * CustomerException { Customer customer = customerRepo.findBycustId(custId);
	 * String returnString = null; LocalDate currentDate = LocalDate.now(); if
	 * (customer != null) { Set<OrderEntity> orders =
	 * getOrdersOfCustByCustId(custId); if (orders != null) { for (OrderEntity order
	 * : orders) { Set<Product> products = order.getProducts(); if (products !=
	 * null) { for (Product product : products) { if
	 * (product.getProductDoe().compareTo(currentDate) <= 0) {
	 * product.setExpired(true); returnString =
	 * "Products expired are flagged, Kindly check and remove from order"; } }
	 * 
	 * } } } else { throw new
	 * CustomerException("No orders placed by that Customer"); } } else { throw new
	 * CustomerException("No Customer with that customer Id"); }
	 * 
	 * return returnString; }
	 */

}
