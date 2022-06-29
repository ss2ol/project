package com.meta.bank.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.meta.bank.dto.Account;
import com.meta.bank.service.AccountService;


@Controller
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	private AccountService accountService;
	
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale) {
		return "bankmain";
	}
	
	@RequestMapping(value = "/makeAccount", method = RequestMethod.GET)
	public String makeAccount() {
		return "makeAccount";
	}
	
	@RequestMapping(value = "/makeAccount", method = RequestMethod.POST)
	public ModelAndView makeAccount(@ModelAttribute Account acc) {
		ModelAndView mav = new ModelAndView();
		try {
			accountService.makeAccount(acc);
			mav.addObject("acc",acc);
			mav.setViewName("accountInfo_res");
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("err","계좌개설 실패");
			mav.setViewName("err");
		}
		return mav;
		
	}
	
	
}
