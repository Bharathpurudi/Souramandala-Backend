package com.souramandala.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souramandala.entity.Address;
import com.souramandala.repo.AddressRepo;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepo addressRepo;

	@Override
	public Address addAddress(Address address) {
		return addressRepo.save(address);
	}

	@Override
	public String deleteAddress(int addId) {
		addressRepo.deleteById(addId);
		return "Address Deleted Sucessfully";
	}

	@Override
	public List<Address> getAddressesOfCust(int custId) {
		return addressRepo.findAllByCustId(custId);
	}

}
