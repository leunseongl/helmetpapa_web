package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDB {

	private static LoginDB instance = new LoginDB();

	public static LoginDB getInstance() {
		return instance;
	}

	public LoginDB() {
	}

	// oracle ����
	String jdbcUrl = "jdbc:oracle:thin:@203.247.52.216:1521:xe";
	String id = "LEM2021";
	String password = "1234";

	Connection conn = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt2 = null;
	ResultSet rs = null;

	String sql = "";
	String sql2 = "";
	boolean returns = false;

	public boolean loginconnectDB(String userID, String userPW) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(jdbcUrl, id, password);

			sql = "SELECT USER_ID, USER_PW FROM USER_TBL WHERE USER_ID = ? and USER_PW = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, userPW);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				returns = true;

			} else {

				returns = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt2 != null)
				try {
					pstmt2.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return returns;
	}

}