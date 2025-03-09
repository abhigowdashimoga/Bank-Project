package com.example.demo.mapper;

import com.example.demo.Dto.CardDto;
import com.example.demo.Entity.Card;

public class CardMapper {
	
	public static Card mapToCardEntity(Card cardentity,CardDto carddto) {
		cardentity.setName(carddto.getName());
		cardentity.setEmail(carddto.getEmail());
		cardentity.setPhoneno(carddto.getPhoneno());
		return cardentity;
		
		
	}

}
