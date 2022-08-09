<%@page import="com.db.RentalDB"%>
<%@ page import="com.db.ConnectDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="org.json.simple.JSONObject"%>


<%
	request.setCharacterEncoding("UTF-8");

	String userID = request.getParameter("userID");

	boolean res = RentalDB.getInstance().insertRental(userID);

	System.out.println(res);
	

%>
