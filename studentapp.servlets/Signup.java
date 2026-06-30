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

@WebServlet("/signup")
public class Signup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDao st = new StudentDaoImp();
		Student s = new Student();
		PrintWriter out = resp.getWriter();
		s.setSname(req.getParameter("name"));
		s.setPhone(Long.parseLong(req.getParameter("phone")));
		s.setEmail(req.getParameter("email"));
		s.setBranch(req.getParameter("branch"));
		s.setLocation(req.getParameter("location"));
		String password = req.getParameter("password");
		String confirm = req.getParameter("confirm");

		if (password.equals(confirm)) {
			s.setPassword(password);
			if (st.insertStudent(s)) {
				RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
				req.setAttribute("successfull", "Register successfull");
				req.setAttribute("student", s);
				rd.forward(req, resp);
//				System.out.println("Register success");
//				out.print("<h1>Register success</h1>");//login.jsp
			} else {
				RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
				req.setAttribute("fail", "failed to register..");
				rd.forward(req, resp);
//				System.out.println("failed to register..");
//				out.print("<h1>failed to register..</h1>");//signup.jsp
			}
		} else {
//			RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
//			req.setAttribute("fail", "password mismatch");
//			rd.forward(req, resp);
			System.out.println("Password mismatch");
			out.print("<h1>Password mismatch</h1>");
		}
	}
}
