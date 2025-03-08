package com.example.demo.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long>{

	Optional<Account> findBycustomerid(Long customerid);

}
