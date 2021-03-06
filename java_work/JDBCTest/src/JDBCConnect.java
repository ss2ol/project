import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnect {
	static Connection conn = null;
	static PreparedStatement stmt = null;
	static ResultSet rs = null;

	public static void insertAccount(String id, String name, int balance0) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			// System.out.println("DB연결 성공");

			String insertSql = "insert into account values (?,?,?)";
			stmt = conn.prepareStatement(insertSql);
			stmt.setNString(1, id);
			stmt.setNString(2, name);
			stmt.setInt(3, balance0);

			int cnt = stmt.executeUpdate();
			System.out.println(cnt + "행이 삽입 되었습니다");
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e2) {

			}
		}
	}

	public static void updateAccount(String id, int money) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			// System.out.println("DB연결 성공");

			String updateSql = "update account set balance = balance+? where id=?";
			stmt = conn.prepareStatement(updateSql);

			stmt.setInt(1, money);
			stmt.setNString(2, id);
			int cnt = stmt.executeUpdate();
			System.out.println(cnt + "행이 변경 되었습니다");
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e2) {

			}
		}

	}

	public static void deleteAccount(String id) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			// System.out.println("DB연결 성공");

			String deleteSql = "delete from account balance = balance+? where id=?";
			stmt = conn.prepareStatement(deleteSql);
			stmt.setNString(1, id);
			int cnt = stmt.executeUpdate();
			System.out.println(cnt + "행이 삭제 되었습니다");
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e2) {

			}
		}
	}

	public static void transferAccount(String sid, String rid, int money) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			conn.setAutoCommit(false); // 이체 트랜젝션을 위해 자동커밋되지 않게 처리
			// System.out.println("DB연결 성공");
			// 보내기
			String sendSql = "update account set balance = balance-? where id=?";

			stmt = conn.prepareStatement(sendSql);
			stmt.setInt(1, money);
			stmt.setNString(2, sid);
			int cnt = stmt.executeUpdate();
			if (cnt == 0) {
				throw new SQLException();
			}
			stmt.close();
			// 받기
			String recvSql = "update account set balance = balance+? where id=?";

			stmt = conn.prepareStatement(recvSql);
			stmt.setInt(1, money);
			stmt.setNString(2, rid);
			cnt = stmt.executeUpdate();
			if (cnt == 0) {
				throw new SQLException();
			}
			conn.commit();

			System.out.println("이체 성공");
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				System.out.println("이체 실패");
				conn.rollback();// 예외 발생시 롤백처리
			} catch (SQLException e2) {
			}
		} finally {
			try {
				if(stmt != null) stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e2) {

			}
		}

	}

	public static void selectAccount(String id) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

			String selectSql = "select * from account where id= ?";
			stmt = conn.prepareStatement(selectSql);
			stmt.setNString(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				String qid = rs.getNString("id");
				String qname = rs.getNString("name");
				int qbalance = rs.getInt("balance");
				System.out.println("계좌번호:" + qid + ",이름:" + qname + ",잔액:" + qbalance);

			}
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {
			e.printStackTrace();

		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt != null) stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e2) {

			}	
		}
	}
	
	
	public static void selectAccountList(){
		Statement statement = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

			String selectAllSql = "select * from account order by id";
			statement = conn.createStatement();
			rs = statement.executeQuery(selectAllSql);
			
			while (rs.next()) {
				String qid = rs.getNString("id");
				String qname = rs.getNString("name");
				int qbalance = rs.getInt("balance");
				System.out.println("계좌번호:" + qid + ",이름:" + qname + ",잔액:" + qbalance);

			}
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {
			e.printStackTrace();

		}finally {
			try {
				if(rs!=null) rs.close();
				if(statement != null) statement.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e2) {

			}	
		}
	}
	

	public static void main(String[] args) {
		// insertAccount("10005", "song", 300000);
		// updateAccount("10005", 100000);
		// deleteAccount("10001");
		//transferAccount("1004", "10005", 20000);
		//selectAccount("1004");
		selectAccountList();
		
	}

}
