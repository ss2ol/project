package com.meta.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.meta.bank.dto.Account;

public class AccountDAOImpl implements AccountDAO {

	private SimpleJdbcInsert jdbcInsert;
	private JdbcTemplate jdbcTemplate;
	
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource =dataSource;
		jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("account");
		jdbcTemplate = new JdbcTemplate(dataSource);
				
	}
	
	@Override
	public void insertAccount(Account acc) throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("id", acc.getId());
		params.put("naem", acc.getName());
		params.put("balance", acc.getBalance());
		jdbcInsert.execute(params);
		
	}

	@Override
	public Account selectAccount(String id) throws Exception {
		String sql = "select * from accunt where id=?";
		Account acc = jdbcTemplate.queryForObject(sql,new Object[] {id},new RowMapper<Account>() {

			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account acc = new Account();
				acc.setId(rs.getNString("id"));
				acc.setName(rs.getNString("name"));
				acc.setBalance(rs.getInt("balnace"));
				return acc;
			}
			
		});
		return acc;
	}

}
