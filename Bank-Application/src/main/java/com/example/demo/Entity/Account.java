package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Account extends BaseEntity{

	private Long customerid;
	
	@Id
	private Long accountNo;
	
	private String accountType;
	
	private String branchAdsress;


}
