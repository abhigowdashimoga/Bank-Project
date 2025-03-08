package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.CardDetailsDto;
import com.example.demo.Dto.CardDto;
import com.example.demo.service.CardService;

@RestController
@RequestMapping("/api/card")
public class CardController {
	
	@Autowired
	private CardService cardservice;
	
	@PostMapping("/createCard")
	public ResponseEntity<String> createCard(@RequestBody CardDto cardDto){
		cardservice.createCard(cardDto);
		return new ResponseEntity<>("card created sucessfully",HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getCardDetails")
	public ResponseEntity<CardDetailsDto> getCardDetails(@RequestParam String phoneno){
		cardservice.getCardDetails(phoneno);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}

}
