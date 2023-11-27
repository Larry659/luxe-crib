package com.example.luxecrib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.luxecrib.model.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    Optional <Account> findAccountByEmail(String email);
}
