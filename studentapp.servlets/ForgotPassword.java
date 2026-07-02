package com.dcl.studentapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.dcl.studentapp.dao.StudentDao;
import com.dcl.studentapp.dao.StudentDaoImp;
import com.dcl.studentapp.dto.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/forgotpassword")
public class ForgotPassword extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDao st = new StudentDaoImp();
		PrintWriter out = resp.getWriter();
		Student s = st.getStudent(req.getParameter("email"), Long.parseLong(req.getParameter("phone")));
		if (s != null) {
			if(req.getParameter("newpassword").equals(req.getParameter("confirm"))) {
				s.setPassword(req.getParameter("newpassword"));
				if(st.updateStudent(s)) {
					out.print("<h1>password update successfully</h1>");
				}
				else {
					out.print("<h1>password not update</h1>");
				}
			}
		} else {
			out.print("<h1>No student found</h1>");
		}
	}

}
