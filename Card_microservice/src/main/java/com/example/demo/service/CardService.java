package com.example.demo.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.demo.Dto.CardDetailsDto;
import com.example.demo.Dto.CardDto;
import com.example.demo.Dto.CustomerDto;
import com.example.demo.Entity.Card;
import com.example.demo.Repo.CardRepo;
import com.example.demo.exception.AccountNotFoundException;
import com.example.demo.feign_client.Feign_interface;
import com.example.demo.mapper.CardDetailsMapper;
import com.example.demo.mapper.CardMapper;

@Service
public class CardService {
	
	@Autowired
	private CardRepo cardrepo;
	
	@Autowired
	private Feign_interface fn;
	

	public void createCard(Long accno,CardDto cardDto) {
				
		CustomerDto Accountno = fn.fetchAccounDetails(cardDto.getPhoneno()).getBody();
		
		Optional<Card> opt1 = cardrepo.findByaccountno(accno);
		
		if(opt1.isEmpty()) {
		
		if((Accountno.getAccountDto().getAccountNo()).equals(accno)) {
			
			Card cardentity = CardMapper.mapToCardEntity(new Card(), cardDto);
			cardentity.setAccountno(Accountno.getAccountDto().getAccountNo());
			Long RanCardNo = 1000000000L + new Random().nextInt(900000000);
			cardentity.setCardno(RanCardNo);
			cardentity.setBalance(100000);
			
			cardrepo.save(cardentity);
			
		}
		else {
			throw new AccountNotFoundException("Account no is not present");
		}
		}
		else{
			throw new AccountNotFoundException("Account no already has card");
		}
	}


	public CardDetailsDto getCardDetails(String phoneno) {

		Card cd = cardrepo.findByphoneno(phoneno)
				.orElseThrow(
						()-> new AccountNotFoundException("Phone no is present"));
		
		CardDetailsDto cdDto = CardDetailsMapper.maoToCardDetailsDto(cd, new CardDetailsDto());
		return cdDto;
		
		
	}

	
	public void deleteCard(Long accountno) {
		
		Card cd = cardrepo.findByaccountno(accountno)
				.orElseThrow(()-> new AccountNotFoundException("Account no is not found"));
		
		cardrepo.delete(cd);
	
	}

}
