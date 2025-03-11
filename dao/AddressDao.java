package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Address;
import com.project.flight_management_system.repo.AddressRepo;

@Repository
public class AddressDao {
	@Autowired
	AddressRepo addressRepo;
	
	public Address saveAddress(Address address) {
		return addressRepo.save(address);
		
	}
	
	public Address fetchAddressById(int addressId) {
		Optional<Address> address=addressRepo.findById(addressId);
		if(address.isPresent()) {
			return address.get();
		}
		else {
			return null;
		}
		
		
	}
	public Address updateAddressById(int oldAddressId,Address newAddress) {
		newAddress.setAddressId(oldAddressId);
	return saveAddress(newAddress);
	}
	public Address deleteAddressById(int addressId) {
		Address address=fetchAddressById(addressId);
		addressRepo.delete(address);
		return address;
	}
	public List<Address> fetchAllAddress(){
		return addressRepo.findAll();
	}
	

}
