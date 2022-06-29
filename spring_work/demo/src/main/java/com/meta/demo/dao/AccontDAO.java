package com.meta.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.meta.demo.dto.Account;

@Mapper
@Repository("accountDAO")
public interface AccontDAO {

	List<Account> accountList();
	
	
}
