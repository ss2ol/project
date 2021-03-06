package service;

import java.sql.Connection;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.List;

import dao.AccountDAO;
import db.JdbcUtil;
import dto.Account;

public class AccountService {
	public void makeAccount(Account acc) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		AccountDAO dao = new AccountDAO();
		
		try {
			dao.insertAccount(conn, acc);
		} catch (Exception e) {
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
	}
	
	public Account accountInfo(String id) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		AccountDAO dao = new AccountDAO();
		Account acc = null;
		try {
			
		acc = dao.selectAccount(conn, id);
		if(acc==null) throw new SQLException();
		} catch (SQLException e) {
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
		return acc;
	}
	
	public List<Account> allAccountInfo() throws Exception{
		Connection conn = JdbcUtil.getConnection();
		AccountDAO dao = new AccountDAO();
		List<Account> accs = null;
		try {
			accs = dao.selectAllAccount(conn);
			if(accs.isEmpty())throw new SQLException();
			
		} catch (SQLException e) {
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
		return accs;
	}
	
	
	public void deposit(String id, int money) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		AccountDAO dao = new AccountDAO();
				
		try {
			if(money <=0)throw new SQLException("입금액 오류");
			Account acc = dao.selectAccount(conn, id);
			if(acc == null) throw new SQLException("계좌번호 오류");
				dao.updateBalance(conn, id, money);
				
		} catch (SQLException e) {
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
	}

	
	public void withdraw(String id, int money) throws SQLException {
		Connection conn = JdbcUtil.getConnection();
		AccountDAO dao = new AccountDAO();
				
		try {
			if(money <=0)throw new SQLException("입금액 오류");
			Account acc = dao.selectAccount(conn, id);
			if(acc == null) throw new SQLException("계좌번호 오류");
			if(acc.getBalance()< money) throw new SQLException(" 오류");
			acc.withdraw(money);	
			dao.updateBalance(conn, id, money);
				
		} catch (SQLException e) {
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
	}
}