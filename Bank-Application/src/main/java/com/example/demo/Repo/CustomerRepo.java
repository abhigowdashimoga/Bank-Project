package com.example.demo.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.Customer;


@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>{
	
	Optional<Customer> findByphoneno(String phoneno);

}
