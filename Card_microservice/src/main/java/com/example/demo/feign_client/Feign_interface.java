package com.example.demo.feign_client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Dto.CustomerDto;


@FeignClient("BANK-APPLICATION")
public interface Feign_interface {
	
	@GetMapping("api/getAccount")
	public ResponseEntity<CustomerDto> fetchAccounDetails(@RequestParam String phoneno);

}
