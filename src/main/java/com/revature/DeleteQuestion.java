package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteQuestion extends HttpServlet {
	public void init() {
	}
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
		QuestionBean bbd=new QuestionBean();
		bbd.setquestionId(req.getParameter("QuestionId"));
		PrintWriter out=res.getWriter();
		Connection con = DataBaseConnection.getConnection();
		try {
			PreparedStatement ps= con.prepareStatement("delete from QuestionManagement where QuestionId=?");
			ps.setString(1,bbd.getquestionId());
			int k=ps.executeUpdate();
			if(k>0) {
				out.println("Question Deleted Successfully...");
			}
			RequestDispatcher rd= req.getRequestDispatcher("/index.html");
			rd.include(req, res);
			
			
		} catch (SQLException e) {
			out.println("question Not Deleted...");
			e.printStackTrace();
		}
		
		
		
   
	
}
	
}
