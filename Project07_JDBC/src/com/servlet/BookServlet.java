package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.2.113:1521:KBPMS";
		String id = "KBPMS";
		String pw = "KBPMS";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		
		try {
			Class.forName(driver);			
			
			con = DriverManager.getConnection(url, id, pw);
			stmt = con.createStatement();
			
			String sql = "SELECT * FROM book";
			res = stmt.executeQuery(sql);
			
			while (res.next()) {
				int bookId = res.getInt("book_id");
				String bookName = res.getString("book_name");
				String bookLoc = res.getString("book_loc");
				
				out.print("bookId :" + bookId + ", ");
				out.print("bookName :" + bookName + ", ");
				out.print("bookLoc :" + bookLoc + "</br>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {			
			try {
				if(stmt != null)	stmt.close();
				if(con != null) 	con.close();
				if(res != null) 	res.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
