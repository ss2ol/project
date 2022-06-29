package com.meta.rest.dto;


public class Article {

	private int articleNO;
	private String writer;
	private String tilte;
	private String content;
	public int getArticleNO() {
		return articleNO;
	}
	public void setArticleNO(int articleNO) {
		this.articleNO = articleNO;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTilte() {
		return tilte;
	}
	public void setTilte(String tilte) {
		this.tilte = tilte;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Article [articleNO=" + articleNO + ", writer=" + writer + ", tilte=" + tilte + ", content=" + content
				+ "]";
	}
	
	
	
	
	
	
}
