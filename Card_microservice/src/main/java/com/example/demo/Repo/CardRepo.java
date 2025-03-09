package com.example.demo.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Card;

@Repository
public interface CardRepo extends JpaRepository<Card, Integer>{

	Optional<Card> findByphoneno(String phoneno);

	Optional<Card> findByaccountno(Long accno);

}
