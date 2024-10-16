package com.financeflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financeflow.model.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{
	
	UserAccount getUserByEmail(String email);
}
