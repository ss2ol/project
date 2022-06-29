package com.meta.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {

	
	@GetMapping("/makeAccount")
	public String makeaccount() {
		return "makeAccount";
	}

	
	@GetMapping("/")
	public String main() {
		return "bankmain";
	}
	
	@GetMapping("/deposit")
	public String deposit() {
		return "deposit";		
	}
	
	@GetMapping("/withdraw")
	public String withdraw() {
		return "withdraw";
	}
	
	@GetMapping("/accountInfo")
	public String accountInfo() {
		return "accountInfo";	
	}

	
	@GetMapping("/allAccountInfo")
	public String allAccountInfo() {
		return "allAccountInfo";	
	}
	
	
	
	
}
