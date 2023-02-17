package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/View")
public class ShowQuestions extends HttpServlet{
	public void init() {
		
	}
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		ArrayList<QuestionBean> al2= new RetriveDAO().retrieve();
		PrintWriter pw= res.getWriter();
		res.setContentType("text/html");
		if(al2.size()==0) {
			System.out.println("Questions Not Available");
		}else {
			Iterator<QuestionBean> itr= al2.iterator();
			while(itr.hasNext()) {
				QuestionBean bb3=(QuestionBean)itr.next();
				pw.println(bb3.getQuestionSection()+"&nbsp&nbsp"+bb3.getquestionId()+"&nbsp&nbsp"+"&nbsp&nbsp"+bb3.getQuestionText()+"<br>");
			}
		}
		RequestDispatcher rd= req.getRequestDispatcher("index.html");
		rd.include(req, res);
		
	}
	public void destroy() {
		
	}
}
