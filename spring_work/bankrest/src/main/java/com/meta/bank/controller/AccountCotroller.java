package com.meta.bank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meta.bank.dto.Account;
import com.meta.bank.service.AccountService;

@RestController
public class AccountCotroller {
	@Autowired
	AccountService accountservice;

	@PostMapping("makeAccount")
	// public ResponseEntity<String> makeAccount(@RequestParam("id") String id,
	// @RequestParam("name")String name,
	// @RequestParam("balance") Integer balance) {

	public ResponseEntity<String> makeAccount(@ModelAttribute Account acc) {
		// Account acc =new Account();
		// acc.setId(id);
		// acc.setName(name);
		// acc.setBalance(balance);
		//
		try {
			accountservice.makeAccoount(acc);
			return new ResponseEntity<String>("계좌 개설 성공", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("계좌 개설 실패", HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/idoverlap/{id}")
	public ResponseEntity<String> idoverlap(@PathVariable("id") String id) {
		String overlapStr = "사용가능한 ID입니다.";

		try {
			if (accountservice.idoverlap(id)) {
				overlapStr = "사용 불가능한 ID입니다.";
				return new ResponseEntity<String>(overlapStr, HttpStatus.OK);
			}
		} catch (Exception e) {
		}
		return new ResponseEntity<String>("중복확인 실패", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Account>> allAccountList() {
		try {
			List<Account> accs = accountservice.accountList();
			return new ResponseEntity<List<Account>>(accs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Account>>(new ArrayList<Account>(),HttpStatus.BAD_REQUEST);
		}
	}

}
