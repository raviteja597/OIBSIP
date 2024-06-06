package com.tap;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String idParam = req.getParameter("id");

	    if (idParam != null && !idParam.isEmpty()) {
	        int id = Integer.parseInt(idParam);
	        String name = req.getParameter("name");
	        String email = req.getParameter("email");
	        String department = req.getParameter("department");
	        
	        String salaryParam = req.getParameter("salary");
	        int salary = 0; 
	        if (salaryParam != null && !salaryParam.isEmpty()) {
	            salary = Integer.parseInt(salaryParam);
	        }

	        Employee e = new Employee(id, name, email, department, salary);

	        EmployeeBO bo = new EmployeeBO();

	        int i = bo.save(e);
	        PrintWriter out = resp.getWriter();

	        if (i == 1) {
	            out.println("Employee saved successfully");
	        } else {
	            out.println("Saving unsuccessfull!!!");
	        }
	    } else {
	        PrintWriter out = resp.getWriter();
	        out.println("Invalid input for 'id' parameter");
	    }
	}
}


