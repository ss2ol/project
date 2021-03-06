package com.meta.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name ="ACCOUNT")
public class AccountEntity {

	@Id //프라이머리키 
	
	private String id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Integer balance;
	
	@Override
	public String toString() {
		return"계좌번호:" +id+"이름:"+name+"잔액:"+balance;
	}
	
}
