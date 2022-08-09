package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.domain.UserVO;

import util.DBManager;

public class UserDAO {

	private static UserDAO instance = new UserDAO();

	public static UserDAO getInstance() {
		return instance;
	}

	public ArrayList<UserVO> getUserList() {

		ArrayList<UserVO> list = new ArrayList<UserVO>();

		String sql = "SELECT USER_ID, NAME, BIRTH_DATE, PHONE FROM USER_TBL";

		try {

			Connection conn = DBManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				UserVO vo = new UserVO();
				vo.setUserID(rs.getString("USER_ID"));
				vo.setName(rs.getString("NAME"));
				vo.setBirth(rs.getString("BIRTH_DATE"));
				vo.setPhone(rs.getString("PHONE"));

				list.add(vo);

			}

		} catch (Exception e) {
			e.getStackTrace();
		}

		return list;

	}

}
