package com.meta.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meta.jpa.dto.Account;
import com.meta.jpa.model.AccountEntity;

public interface AccountService {
	Account accountInfo(String id) throws Exception;
	List<AccountEntity> accountList() throws Exception;
	void makeAccount(Account acc) throws Exception;
	void deposit(String id, int money) throws Exception;
	void withdraw(String id, int money) throws Exception; 
	
}
