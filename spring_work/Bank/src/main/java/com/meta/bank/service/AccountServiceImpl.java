package com.meta.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meta.bank.dao.AccountDAO;
import com.meta.bank.dto.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDAO accountDAO;

	@Override
	public Account accountInfo(String id) throws Exception {

		return accountDAO.selectOne(id);
	}

	@Override
	public List<Account> accountList() throws Exception {
		return accountDAO.selectAll();
	}

	@Override
	public void makeAccoount(Account acc) throws Exception {
//		try {
//			accountDAO.insertOne(acc);
//		} catch (Exception e) {
//			System.out.println(e.getLocalizedMessage());
//		}
		accountDAO.insertOne(acc);

	}

	@Override
	public void deposit(String id, int money) throws Exception {
		if (money <= 0)
			throw new Exception("입금 오류");
		Account acc = accountDAO.selectOne(id);
		if (acc == null)
			throw new Exception("계좌 번호 오류");
		acc.deposit(money);
		accountDAO.updateBalance(acc);
	}

	@Override
	public void withdraw(String id, int money) throws Exception {
		if (money <= 0)
			throw new Exception("출금 오류");
		Account acc = accountDAO.selectOne(id);
		if (acc == null)
			throw new Exception("계좌 번호 오류");
		acc.withdraw(money);
		accountDAO.updateBalance(acc);
	}

}
