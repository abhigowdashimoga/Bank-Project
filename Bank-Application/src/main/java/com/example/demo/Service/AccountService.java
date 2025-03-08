package com.example.demo.Service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.AccountDto;
import com.example.demo.Dto.CustomerDto;
import com.example.demo.Entity.Account;
import com.example.demo.Entity.Customer;
import com.example.demo.Exception.CustomerAlreadyExists;
import com.example.demo.Exception.ResourseNotFound;
import com.example.demo.Mapper.AccountMapper;
import com.example.demo.Mapper.CustomerMapper;
import com.example.demo.Repo.AccountRepo;
import com.example.demo.Repo.CustomerRepo;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepo accRepo;
	@Autowired
	private CustomerRepo custRepo;
	
	public void createAccount(CustomerDto customerDto) {
		Customer customer = CustomerMapper.MaptoCust(customerDto, new Customer());
		
		Optional<Customer>opt =custRepo.findByphoneno(customerDto.getPhoneno());
		
		if(opt.isPresent()) {
			throw new CustomerAlreadyExists("mobile no already exist");
		}
		else {
		Customer cust=custRepo.save(customer);
		accRepo.save(createNewAccount(cust));
		}
	}
	
	private Account createNewAccount(Customer customer) {
		Account acc=new Account();
		acc.setCustomerid(customer.getCustomerid());
		Long RanAccountNo = 1000000000L + new Random().nextInt(900000000);
		acc.setAccountNo(RanAccountNo);
		acc.setAccountType("savings");
		acc.setBranchAdsress("kormangala branch");
		return acc;
	}

	public CustomerDto getAccountDetails(String phoneno) {
		Customer cust = custRepo.findByphoneno(phoneno)
				.orElseThrow(()->new ResourseNotFound("mobile no not found"));
		
		Account acc = accRepo.findBycustomerid(cust.getCustomerid())
				.orElseThrow(()->new ResourseNotFound("mobile no not found"));
		
		CustomerDto custDto = CustomerMapper.MaptoCustDto(new CustomerDto(), cust);
		custDto.setAccountDto(AccountMapper.mapToAccountDto(acc, new AccountDto()));
		
		return custDto;
	}
	
	public boolean updateCustomer(CustomerDto customerDto) {
		boolean isupdated=false;
		
		AccountDto accDto = customerDto.getAccountDto();
		if(accDto!=null) {
			Account acc = accRepo.findById(accDto.getAccountNo())
					.orElseThrow(()->new ResourseNotFound("AccountNo is not found"));
			
			AccountMapper.mapToAccount(acc, accDto);
			acc = accRepo.save(acc);
			
			Long custId = acc.getCustomerid();
			
			Customer cust = custRepo.findById(custId)
					.orElseThrow(()->new ResourseNotFound("Customer is not found"));
			
			CustomerMapper.MaptoCust(customerDto, cust);
			custRepo.save(cust);
			isupdated=true;
		}
		
		return isupdated;    
	}
	
	public void deleteAcc(Long accountNo) {
		Account acc = accRepo.findById(accountNo)
				.orElseThrow(()->new ResourseNotFound("Account no not found"));
		
			accRepo.deleteById(accountNo);
			custRepo.deleteById(acc.getCustomerid());

	}
}
