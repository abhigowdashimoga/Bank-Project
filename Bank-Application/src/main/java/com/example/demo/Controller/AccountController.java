package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.CustomerDto;
import com.example.demo.Service.AccountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="CRUD REST APi for BankAccount",description = "Bank Account")
@RestController
@RequestMapping("/api")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Operation(summary = "create Account",description = "Api to create account")
	@PostMapping("/create")
	public ResponseEntity<String> createAccount(@RequestBody CustomerDto customerDto){
		accountService.createAccount(customerDto);
		return new ResponseEntity<>("Account Created",HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getAccount")
	public ResponseEntity<CustomerDto> fetchAccounDetails(@RequestParam String phoneno){
		CustomerDto custDto = accountService.getAccountDetails(phoneno);
		return ResponseEntity.status(HttpStatus.OK).body(custDto);
		
	}
	
	@PutMapping("/updateAccount")
	public ResponseEntity<String> updateAccDetail(@RequestBody CustomerDto customerDto){
		boolean isupdated = accountService.updateCustomer(customerDto);
		
		if(isupdated) {
			
			return new ResponseEntity<>("updated",HttpStatus.CREATED);
		}
		else {
			
			return new ResponseEntity<>("Account not found",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteAccDetail(@RequestParam Long accountNo){
		accountService.deleteAcc(accountNo);
		return new ResponseEntity<>("Account Deleted",HttpStatus.OK);
		
	}

}
