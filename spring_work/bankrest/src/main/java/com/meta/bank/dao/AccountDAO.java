package com.meta.bank.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.meta.bank.dto.Account;

@Mapper
@Repository
public interface AccountDAO {
	Account selectOne(String id) throws Exception;

	List<Account> selectAll() throws Exception;

	void insertOne(Account acc) throws Exception;

	void updateBalance(Account acc) throws Exception;
	
	void deposit(@Param("id")String id, @Param("money") int money);
}
