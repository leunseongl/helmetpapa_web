package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBManager;

public class AdminDAO {

	private static AdminDAO instance = new AdminDAO();

	public static AdminDAO getInstance() {
		return instance;
	}

	public boolean checkLogin(String adminID, String adminPW) {

		boolean res = false;

		String sql = "SELECT ADMIN_ID, ADMIN_PW FROM ADMIN_TBL WHERE ADMIN_ID = ? AND ADMIN_PW =?";

		try {

			Connection conn = DBManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminID);
			pstmt.setString(2, adminPW);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				res = true;
			}

		} catch (Exception e) {
			res = false;
			e.getStackTrace();
		}

		return res;

	}

}
