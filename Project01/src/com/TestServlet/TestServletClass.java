package com.TestServlet;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TSC")
public class TestServletClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestServletClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("----- doGet() -----");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	@PostConstruct
	public void postCon() {

		System.out.println("----- PostConstruct() -----");		
	}
	
	@Override
	public void init() throws ServletException {

		System.out.println("----- init() -----");
	}
	
	@Override
	public void destroy() {

		System.out.println("----- Destroy() -----");
	}
	@PreDestroy
	public void preDes() {
		
		System.out.println("----- @PreDestroy() -----");
	}
}
