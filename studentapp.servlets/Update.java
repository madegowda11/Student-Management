package com.dcl.studentapp.servlets;

import java.io.IOException;

import com.dcl.studentapp.dao.StudentDao;
import com.dcl.studentapp.dao.StudentDaoImp;
import com.dcl.studentapp.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class Update extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        StudentDao dao = new StudentDaoImp();

        Student s = new Student();

        int sid = Integer.parseInt(req.getParameter("sid"));
//        long phone = Long.parseLong(req.getParameter("phone"));

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String branch = req.getParameter("branch");
        String location = req.getParameter("location");
        String password = req.getParameter("password");

        s.setSid(sid);
        s.setSname(name);
//        s.setPhone(phone);
        s.setEmail(email);
        s.setBranch(branch);
        s.setLocation(location);
        s.setPassword(password);

        boolean result = dao.updateStudent(s);

        if (result) {
            req.setAttribute("success", "Details Updated Successfully");
            RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
            rd.forward(req, resp);
            System.out.println("Update Successful");
        } else {
            req.setAttribute("fail", "Update Failed");
            RequestDispatcher rd = req.getRequestDispatcher("update.jsp");
            rd.forward(req, resp);
            System.out.println("Updated failed");
        }
    }
}
