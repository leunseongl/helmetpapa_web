package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {

	// 데이터베이스 접속
	public static Connection getConnection() {

		Connection conn = null;

		String url = "jdbc:oracle:thin:@203.247.52.216:1521:xe";
		String id = "LEM2021";
		String pw = "1234";

		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		

		return conn;

	}

	// select을 수행한 후 리소스 해제를 위한 메소드 -> ResultSet
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// insert, update, delete 작업을 수행한 후 리소스 해제를 위한 메소드
	public static void close(Connection conn, Statement stmt) {
		try {
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
