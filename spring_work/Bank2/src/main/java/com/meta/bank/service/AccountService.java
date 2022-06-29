package com.meta.bank.service;

import com.meta.bank.dto.Account;

public interface AccountService {
	void makeAccount(Account acc ) throws Exception;
	Account accountInfo (String id) throws Exception;
	void deposit (String id, int money) throws Exception;
	void withdraw (String id, int money) throws Exception;
	
}
