package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB {
   private static ConnectDB instance = new ConnectDB();

   public static ConnectDB getInstance() {
      return instance;
   }

   public ConnectDB() {
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
   

   public String connectionDB(String userID, String userPW, String userNAME, String userBIRTH, String userPHONE) {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn = DriverManager.getConnection(jdbcUrl, id, password);

         sql = "SELECT USER_ID FROM USER_TBL WHERE USER_ID = ?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, userID);

         rs = pstmt.executeQuery();

         if (rs.next()) {

            returns = "이미 존재하는 아이디입니다.";

         } else {

            sql2 = "INSERT INTO USER_TBL VALUES(?,?,?,?,?)";
            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setString(1, userID);
            pstmt2.setString(2, userPW);
            pstmt2.setString(3, userNAME);
            pstmt2.setString(4, userBIRTH);
            pstmt2.setString(5, userPHONE);
            pstmt2.executeUpdate();
            returns = "회원가입 성공!";
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