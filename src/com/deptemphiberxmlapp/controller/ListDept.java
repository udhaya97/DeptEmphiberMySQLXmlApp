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
 * Servlet implementation class ListEmpDept
 */
@WebServlet("/listdept")
public class ListDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListDept() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DeptEmpService der = new DeptEmpServImpl();
		List<Department> lst = der.readAllDeptServ();
	
		HttpSession sc=request.getSession();
		
		request.setAttribute("dbased", "onlydept");
		request.setAttribute("dval", lst);
		
		request.setAttribute("lis", sc.getAttribute("lisvaldept"));
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("home3.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
