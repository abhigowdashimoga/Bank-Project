package com.example.demo.Mapper;

import com.example.demo.Dto.CustomerDto;
import com.example.demo.Entity.Customer;

public class CustomerMapper {
	
	public static CustomerDto MaptoCustDto(CustomerDto customerDto,Customer customer) {
		customerDto.setName(customer.getName());
		customerDto.setEmail(customer.getEmail());
		customerDto.setPhoneno(customer.getPhoneno());
		return customerDto;
	}
	
	public static Customer MaptoCust(CustomerDto customerDto,Customer customer) {
		customer.setName(customerDto.getName());
		customer.setEmail(customerDto.getEmail());
		customer.setPhoneno(customerDto.getPhoneno());
		return customer;
	}

}
