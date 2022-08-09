package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDAO;
import com.dao.UserDAO;
import com.domain.UserVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String adminID = request.getParameter("adminID");
		String adminPW = request.getParameter("adminPW");
		String url="";

		boolean res = AdminDAO.getInstance().checkLogin(adminID, adminPW);

		if(res){

			// 로그인 성공하면 메인(user) 화면으로 이동
			HttpSession session = request.getSession();
			session.setAttribute("adminID", adminID);
			session.setAttribute("adminPW", adminPW);

			url = "index.jsp";
			
			// 사용자 정보 목록 출력
			ArrayList<UserVO> list = UserDAO.getInstance().getUserList();
			request.setAttribute("list", list);

			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
			
			

		}else{

			// 다시 로그인 화면으로 이동
			url = "login.jsp";

			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		
		//return url;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
