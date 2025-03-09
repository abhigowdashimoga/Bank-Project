package com.example.demo.Dto;

import lombok.Data;

@Data
public class CustomerDto {
	
    private String name;
	
	private String email;
	
	private String phoneno;
	
	private AccountDto accountDto;
	
}
