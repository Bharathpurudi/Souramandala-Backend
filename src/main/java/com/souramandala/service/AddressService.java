package com.souramandala.service;

import java.util.List;

import com.souramandala.entity.Address;

public interface AddressService {
	
	public abstract Address addAddress(Address address);
	public abstract String deleteAddress(int addId);
	
	public abstract List<Address> getAddressesOfCust(int custId);

}
