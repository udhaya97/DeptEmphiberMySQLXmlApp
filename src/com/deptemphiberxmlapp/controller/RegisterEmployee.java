package com.deptemphiberxmlapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deptemphiberxmlapp.dao.DeptEmpDao;
import com.deptemphiberxmlapp.dao.DeptEmpDaoImpl;
import com.deptemphiberxmlapp.model.Department;
import com.deptemphiberxmlapp.model.Employee;
import com.deptemphiberxmlapp.service.DeptEmpServImpl;
import com.deptemphiberxmlapp.service.DeptEmpService;

/**
 * Servlet implementation class RegisterEmployee
 */
@WebServlet("/addemployee")
public class RegisterEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptEmpService danew =new DeptEmpServImpl();
		HttpSession sef = request.getSession();
		int deptId = (int) sef.getAttribute("deIdFromLis");
		List<Employee> lsty = danew.readEmpFromDeptServ(deptId);
	
		List<Department> ldeptval = danew.readAllDeptServ();
		String stg =request.getParameter("empId");
		if(stg==null)
		{
		
		//request.setAttribute("dept",sef.getAttribute("lisvaldept") );
		request.setAttribute("hom", "homep");
		request.setAttribute("valcheck", "regemployee");
		request.setAttribute("lis",ldeptval);
		//request.setAttribute("dval",sef.getAttribute("dval"));
		request.setAttribute("val",lsty);
		RequestDispatcher rd = request.getRequestDispatcher("home3.jsp");
	rd.forward(request, response);}
	else
	{
		int x=Integer.parseInt(stg);
		if(x==0)
		{
			request.setAttribute("hom", "homep");
			request.setAttribute("newtab", "ntabl");
		request.setAttribute("val",lsty);
		RequestDispatcher rd = request.getRequestDispatcher("home3.jsp");
	       rd.forward(request, response);
		}
		
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
