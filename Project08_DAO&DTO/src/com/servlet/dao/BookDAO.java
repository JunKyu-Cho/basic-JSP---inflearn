package com.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.servlet.dto.BookDTO;

public class BookDAO {
	/*
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.2.113:1521:KBPMS";
	String id = "KBPMS";
	String pw = "KBPMS";
	*/
	
	DataSource dataSource;
	
	public BookDAO() {
		try {
//			Class.forName(driver);
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BookDTO> select() {
		
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
//			con = DriverManager.getConnection(url, id, pw);
			con = dataSource.getConnection();
			
			String sql = "SELECT * FROM book";
			pstmt = con.prepareStatement(sql);			
			res = pstmt.executeQuery(sql);
			
			while (res.next()) {
				int bookId = res.getInt("book_id");
				String bookName = res.getString("book_name");
				String bookLoc = res.getString("book_loc");
				
				BookDTO book = new BookDTO(bookId, bookName, bookLoc);
				list.add(book);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {			
			try {
				if(pstmt != null)	pstmt.close();
				if(con != null) 	con.close();
				if(res != null) 	res.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}			
		}
		
		return list;
	}
}
