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
 * Servlet implementation class EditEmployee
 */
@WebServlet("/editemployee")
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int empId=Integer.parseInt(request.getParameter("empId"));
		System.out.println("employee id at edit employee is "+empId);
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		DeptEmpService edfd = new DeptEmpServImpl();
		Employee emp = (Employee) edfd.readEmployeeServ(empId);
		Department df = edfd.showDeptServ(emp.getDepartment().getDeptId());
		System.out.println("edit page value"+emp.getEmpName());
		HttpSession sed = request.getSession();
		List<Employee> listFromDept=edfd.readEmpFromDeptServ(deptId);
		sed.setAttribute("empp", emp);
		request.setAttribute("mainemps", "checktableedit");
		request.setAttribute("empl", emp);
		request.setAttribute("hom", "homep");
		request.setAttribute("addlin", "anemp");
		request.setAttribute("lis", sed.getAttribute("lisvaldept"));
		request.setAttribute("val", listFromDept);
		request.setAttribute("dfg", df);
		
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
