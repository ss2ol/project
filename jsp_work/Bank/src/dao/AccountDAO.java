package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.JdbcUtil;
import dto.Account;

public class AccountDAO {
	public void insertAccount(Connection conn, Account acc) throws SQLException {
		String sql = "insert into account (id, name, balance) values (?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, acc.getId());
			pstmt.setNString(2, acc.getName());
			pstmt.setInt(3, acc.getBalance());
			pstmt.executeQuery();
		} catch (SQLException e) {
			throw e;
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

	public Account selectAccount(Connection conn, String id) throws SQLException {
		String sql = "select * from account where id =?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Account acc = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, id);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				acc = new Account(rset.getNString(1), rset.getNString(2), rset.getInt(3));
			}
		} catch (SQLException e) {
			throw e;

		} finally {
			JdbcUtil.close(rset);
			JdbcUtil.close(pstmt);
		}
		return acc;
	}

	public List<Account> selectAllAccount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rset = null;
		List<Account> accs = new ArrayList<>();
		String sql = "select * from account";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			while (rset.next()) {
				String id = rset.getNString("id");
				String name = rset.getNString("name");
				int balance = rset.getInt("balance");
				accs.add(new Account(id, name, balance));

			}
		} catch (SQLException e) {
			throw e;
		} finally {
			JdbcUtil.close(rset);
			JdbcUtil.close(stmt);
		}
		return accs;
	}
	
	
	public void updateBalance(Connection conn, String id, int money) throws SQLException{
		PreparedStatement pstmt = null;
		String sql = "update Account set balance = balance+?, where id=?";
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, money);
			pstmt.setNString(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw e;
			
		}finally {
			JdbcUtil.close(pstmt);
		}
	}

}
