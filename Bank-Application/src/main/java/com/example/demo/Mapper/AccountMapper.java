package com.example.demo.Mapper;

import com.example.demo.Dto.AccountDto;
import com.example.demo.Entity.Account;

public class AccountMapper {
	
	public static AccountDto mapToAccountDto(Account account,AccountDto accountDto) {
		accountDto.setAccountNo(account.getAccountNo());
		accountDto.setAccountType(account.getAccountType());
		accountDto.setBranchAdsress(account.getBranchAdsress());
		return accountDto;
	}
	
	public static Account mapToAccount(Account account,AccountDto accountDto) {
		account.setAccountNo(accountDto.getAccountNo());
		account.setAccountType(accountDto.getAccountType());
		account.setBranchAdsress(accountDto.getBranchAdsress());
		return account;
	}

}
