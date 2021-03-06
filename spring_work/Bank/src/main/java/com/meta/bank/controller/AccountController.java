package com.meta.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.meta.bank.dto.Account;
import com.meta.bank.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	AccountService accountService;

	// @RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String main() {
		return "bankmain";
	}

	@GetMapping("makeAccount")
	public String makeAccount() {
		return "makeAccount";
	}

	@PostMapping("makeAccount")
	public ModelAndView makeAccount(@ModelAttribute Account acc) {
		ModelAndView mav = new ModelAndView();
		try {
			accountService.makeAccoount(acc);
			Account racc = accountService.accountInfo(acc.getId());
			mav.setViewName("accountInfo");
			mav.addObject("acc", racc);
		} catch (Exception e) {
			mav.setViewName("err");
			mav.addObject("err", "계좌개설 오류");
		}
		return mav;
	}

	@GetMapping("accountInfo")
	public String accountInfo() {
		return "accountInfo";
	}

	@PostMapping("accountInfo")
	public String accountInfo(@RequestParam("id") String id, Model model) {
		try {
			Account acc = accountService.accountInfo(id);
			model.addAttribute("acc", acc);
			return "accountInfo_res";
		} catch (Exception e) {
			model.addAttribute("err", e.getMessage());
			return "err";
		}
	}

	@GetMapping("deposit")
	public String deposit() {
		return "deposit";
	}

	@PostMapping("deposit")
	public ModelAndView deposit(@RequestParam("id") String id, @RequestParam("money") int money) {
		ModelAndView mav = new ModelAndView();

		try {
			accountService.deposit(id, money);
			Account acc = accountService.accountInfo(id);
			mav.addObject("acc", acc);
			mav.setViewName("accountInfo_res");

		} catch (Exception e) {
			mav.addObject("err", e.getMessage());
			mav.setViewName("err");
		}
		return mav;
	}

	@GetMapping("withdraw")
	public String withdraw() {
		return "withdraw";
	}

	@PostMapping("withdraw")
	public ModelAndView withdraw(@RequestParam("id") String id, @RequestParam("money") int money) {
		ModelAndView mav = new ModelAndView();

		try {
			accountService.withdraw(id, money);
			Account acc = accountService.accountInfo(id);
			mav.addObject("acc", acc);
			mav.setViewName("accountInfo_res");

		} catch (Exception e) {
			mav.addObject("err", e.getMessage());
			mav.setViewName("err");
		}
		return mav;
	}

	@GetMapping("allAccountInfo")
	public ModelAndView allAccountInfo() {
		ModelAndView mav = new ModelAndView();
		try {
			List<Account> accs = accountService.accountList();
			mav.addObject("accs", accs);
			mav.setViewName("allAccountInfo");
		} catch (Exception e) {
			mav.addObject("err", "전체계좌 조회 오휴");
			mav.setViewName("err");
		}

		return mav;
	}

}