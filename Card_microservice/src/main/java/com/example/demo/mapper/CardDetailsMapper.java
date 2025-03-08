package com.example.demo.mapper;

import com.example.demo.Dto.CardDetailsDto;
import com.example.demo.Entity.Card;

public class CardDetailsMapper {
	
	public static CardDetailsDto maoToCardDetailsDto(Card card,CardDetailsDto carddetailsdto) {
		
		carddetailsdto.setAccountno(card.getAccountno());
		carddetailsdto.setName(card.getName());
		carddetailsdto.setEmail(card.getEmail());
		carddetailsdto.setPhoneno(card.getPhoneno());
		carddetailsdto.setCardno(card.getCardno());
		carddetailsdto.setBalance(card.getBalance());
		return carddetailsdto;
	}

}
