<%@ page import="com.db.LoginDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.JSONObject"%>

<%

	LoginDB connectDB = LoginDB.getInstance();

	String userID = request.getParameter("userID");
	String userPW = request.getParameter("userPW");

	boolean returns = connectDB.loginconnectDB(userID, userPW);

	System.out.println(returns);

	if (returns) { // 로그인 성공 

		// 안드로이드로 전송
		JSONObject jObject = new JSONObject(); // JSON내용을 담을 객체.
		jObject.put("success", returns);

		jObject.put("userID", userID);
		jObject.put("userPW", userPW);

		System.out.println(jObject.toString());

		// 안드로이드로 전송
		response.getWriter().write(jObject.toString());

	} else {
		
		// 안드로이드로 전송
		JSONObject jObject = new JSONObject(); // JSON내용을 담을 객체.
		jObject.put("success", returns);
		
		System.out.println(jObject.toString());

		// 안드로이드로 전송
		response.getWriter().write(jObject.toString());

	}
%>