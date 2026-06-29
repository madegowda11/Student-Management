package com.dcl.studentapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.dcl.studentapp.dao.StudentDao;
import com.dcl.studentapp.dao.StudentDaoImp;
import com.dcl.studentapp.dto.Student;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDao st = new StudentDaoImp();
		PrintWriter out = resp.getWriter();

		long phone = (Long.parseLong(req.getParameter("phone")));
		String password = req.getParameter("password");
		Student s = st.getstudent(phone, password);
		if (s != null) {
			HttpSession session=req.getSession(true);
			RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");
			req.setAttribute("success", "login successfull");
			session.setAttribute("student", s);
			rd.forward(req, resp);
//			System.out.println("Login Successfull...");
//			out.print("<h1>Login Successfull...</h1>");
		} else {
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			req.setAttribute("failed", "login failed");
			rd.forward(req, resp);
//			System.out.println("Login failed...");
//			out.print("<h1>Login failed...</h1>");
		}
	}

}
