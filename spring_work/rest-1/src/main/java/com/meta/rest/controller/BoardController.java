package com.meta.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meta.rest.dto.Article;

@RestController
public class BoardController {

	@PostMapping("/boards")
	@RequestMapping(value ="/boards/{articleNo}", method = RequestMethod.POST)
	public ResponseEntity<String> addArticle(@RequestBody Article article){
		ResponseEntity<String> result = null;
		try {
			System.out.println(article);
			result = new ResponseEntity<String>("새글 등록 성공", HttpStatus.OK);
		} catch (Exception e) {
			result = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		
		}
		return result;
	}
	
	@GetMapping("/boards/{articleNo}")
	@RequestMapping(value ="/boards/{articleNo}", method = RequestMethod.GET )
	public ResponseEntity<Article> findArticle(@PathVariable("articleNo") Integer articleNo){
		//articleNo로 DB에서 데이터 가져옴
		Article article = new Article();
		article.setArticleNO(articleNo);
		article.setWriter("김연아");
		article.setTilte("동계올림픽");
		article.setContent("피겨여왕");
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}
	
	@PutMapping("/boards/{articleNo}")
	@RequestMapping(value ="/boards/{articleNo}", method = RequestMethod.PUT)
	public ResponseEntity<String> modArticle(@PathVariable("articleNo") Integer articleNo,
			@RequestBody Article article){
		try {
			//DB에서 articleNo록 검색하여 article로 수정
			System.out.println(articleNo);
			System.out.println(article);
			return new ResponseEntity<String>("글 수정 성공", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@DeleteMapping("/boards/{articleNo}")
	public ResponseEntity<String> deleteArticle(@PathVariable("articleNo") Integer articleNo){
		System.out.println(articleNo);
		//DB에서 articleNo록 검색하여 article로 삭제
		return new ResponseEntity<String>("글 삭제 성공", HttpStatus.OK);
	}
	
	
}
