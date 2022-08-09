package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.domain.RentalVO;

import util.DBManager;

public class RentalDAO {

	private static RentalDAO instance = new RentalDAO();

	public static RentalDAO getInstance() {
		return instance;
	}

	public ArrayList<RentalVO> getRentalList() {

		ArrayList<RentalVO> list = new ArrayList<RentalVO>();

		String sql = "SELECT NO, USER_ID, RENT_TIME FROM RENTAL_TBL ORDER BY RENT_TIME DESC";

		try {

			Connection conn = DBManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				RentalVO vo = new RentalVO();
				vo.setNo(rs.getString("NO"));
				vo.setUserID(rs.getString("USER_ID"));
				vo.setRent_time(rs.getString("RENT_TIME"));

				list.add(vo);

			}

		} catch (Exception e) {
			e.getStackTrace();
		}

		return list;

	}

}
