package com.souramandala.service;





import com.souramandala.entity.Customer;
import com.souramandala.exception.CustomerException;

public interface CustomerService {
	
	public abstract String createUser(Customer customer) throws CustomerException;
	
	public abstract Customer getCustomerById(int custId) throws CustomerException;
	
	public abstract Customer getCustomerByUsername(String userName) throws CustomerException;
	
	public abstract Customer updateCustomerDetails(Customer customer) throws CustomerException;
	
	public abstract String deleteCustomerById(int custId) throws CustomerException;
	
	public abstract Customer updateFeildsOfCustomer(String firstName, String lastName, String password, String mobNum, String mailId, int custId);
	
	public abstract Customer updatePassword(String userName, String password);
	//public abstract Set<OrderEntity> getOrdersOfCustByCustId(int custId) throws CustomerException;
	
	//public abstract String validateTheOrdersOfCustomer(int custId) throws CustomerException;

}
