package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/modifyBook")
public class ModifyBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.2.113:1521:KBPMS";
		String id = "KBPMS";
		String pw = "KBPMS";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {			
			Class.forName(driver);			
			
			con = DriverManager.getConnection(url, id, pw);
			
			String sql = "UPDATE book SET book_loc = ? WHERE book_name = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  "0001-2222");
			pstmt.setString(2, "bookNo2");
			
			if (pstmt.executeUpdate() != 0) {
				out.print("UPDATE Success!!");
			} else {
				out.print("UPDATE Fail!!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {			
			try {
				if(pstmt != null)	pstmt.close();
				if(con != null) 	con.close();
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
