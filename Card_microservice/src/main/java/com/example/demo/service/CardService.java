package com.example.demo.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Feign_interface;
import com.example.demo.Dto.CardDetailsDto;
import com.example.demo.Dto.CardDto;
import com.example.demo.Dto.CustomerDto;
import com.example.demo.Entity.Card;
import com.example.demo.Repo.CardRepo;
import com.example.demo.mapper.CardDetailsMapper;
import com.example.demo.mapper.CardMapper;

@Service
public class CardService {
	
	@Autowired
	private CardRepo cardrepo;
	
	@Autowired
	private Feign_interface fn;
	

	public void createCard(CardDto cardDto) {
				
		CustomerDto Accountno = fn.fetchAccounDetails(cardDto.getPhoneno()).getBody();
		
		if(Accountno.getAccountDto().getAccountNo()==cardDto.getAccountno()) {
			
			Card cardentity = CardMapper.mapToCardEntity(new Card(), cardDto);
			cardentity.setAccountno(Accountno.getAccountDto().getAccountNo());
			Long RanCardNo = 1000000000L + new Random().nextInt(900000000);
			cardentity.setCardno(RanCardNo);
			cardentity.setBalance(100000);
			
			cardrepo.save(cardentity);
			
		}
	}


	public CardDetailsDto getCardDetails(String phoneno) {

		Card cd = cardrepo.findByphoneno(phoneno).get();
		CardDetailsDto cdDto = CardDetailsMapper.maoToCardDetailsDto(cd, new CardDetailsDto());
		return cdDto;
		
		
	}

}
