package com.meta.ck.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {
	@Autowired
	private ServletContext sevletConext;
	
	@GetMapping("/")
	public String home() {
		return "ckeditor5";
	}
	
	@ResponseBody
	@PostMapping("/upload")
	public Map<String, Object> fileupload(@RequestParam(value ="upload") MultipartFile file ){
		String path = sevletConext.getRealPath("/upload");
		String filename = file.getOriginalFilename();
		File destfile = new File(path+filename);
		Map<String, Object> json = new HashMap<>();
		try {
			file.transferTo(destfile);
			json.put("uploaded", 1);
			json.put("filename", filename);
			json.put("url","/fileview/" +filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	
	@GetMapping("fileview/{filename}")
	public void fileview (@PathVariable String filename, HttpServletResponse response) {
		String path = sevletConext.getRealPath("/upload");
		File file = new File(path+filename);
		FileInputStream fis = null;
		try {
			OutputStream out = response.getOutputStream();
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis,out);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis == null) fis.close();
			} catch (Exception e2) {
				
			}
		}
	}
	
	@PostMapping("/write")
	public String write(@RequestParam(value ="title") String title,
			@RequestParam("content") String content, Model model){
		System.out.println(title);
		System.out.println(content.trim());
		model.addAttribute("title",title);
		model.addAttribute("content", content);
		return "result5";	
	}
	
	
	
	
}
