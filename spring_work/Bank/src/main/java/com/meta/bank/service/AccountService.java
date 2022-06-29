package com.meta.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meta.bank.dao.AccountDAO;
import com.meta.bank.dto.Account;

public interface AccountService {
	Account accountInfo(String id) throws Exception;
	List<Account> accountList() throws Exception;
	void makeAccoount(Account acc) throws Exception;
	void deposit(String id, int money) throws Exception;
	void withdraw(String id, int money) throws Exception; 
	
}
