package com.meta.bank.dao;

import com.meta.bank.dto.Account;

public interface AccountDAO {
	void insertAccount(Account acc) throws Exception;
	
	Account selectAccount(String id) throws Exception;

}
