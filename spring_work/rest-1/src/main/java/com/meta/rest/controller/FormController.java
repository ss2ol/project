package com.meta.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {
	
	@GetMapping("/jsontest")
	public String jsontest() {
		return "jsontest";
	}
	
	@GetMapping("/objjson")
	public String objjson() {
		return "objjsons";
	}
	
	
	@GetMapping("/objmap")
	public String objmap() {
		return "objmap";
	}

}
