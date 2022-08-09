<%@ page import="com.db.ConnectDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="org.json.simple.JSONObject"%>


<%
	request.setCharacterEncoding("UTF-8");

	ConnectDB connectDB = ConnectDB.getInstance();

	String userID = request.getParameter("userID");
	String userPW = request.getParameter("userPW");
	String userNAME = request.getParameter("userNAME");
	String userBIRTH = request.getParameter("userBIRTH");
	String userPHONE = request.getParameter("userPHONE");

	String returns = connectDB.connectionDB(userID, userPW, userNAME, userBIRTH, userPHONE);

	System.out.println(returns);
	

%>
