package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RentalDB {
	private static RentalDB instance = new RentalDB();

	public static RentalDB getInstance() {
		return instance;
	}

	public RentalDB() {
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
	String returns = "a";

	public boolean insertRental(String userID) {
		boolean res = false;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(jdbcUrl, id, password);

			sql = "INSERT INTO RENTAL_TBL VALUES (SEQ_RENTAL_TBL.NEXTVAL, ? , sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);

			res = pstmt.execute();

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

		return res;
	}
}