package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/add")
public class AddQuestionSarvlet extends HttpServlet {
	public void init() {
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
		QuestionBean bb = new QuestionBean();
		
		ArrayList<QuestionBean> obj =new ArrayList<QuestionBean>();
		bb.setquestionId(req.getParameter("questionId"));
		bb.setQustionSection(req.getParameter("questionSection"));
		
		bb.setQuestionText(req.getParameter("questionText"));
		
		obj.add(bb);
		int k=new InsertDAO().insert(bb);
		res.setContentType("text/html");
		PrintWriter pw= res.getWriter();
		if(k>0) {
			pw.println("Product Updated<br>");
		}
		 req.setAttribute("kunal", bb);
			RequestDispatcher rd= req.getRequestDispatcher("/qs.jsp");
			rd.include(req, res);
			
	}
	public void destroy() {
		
	}
}
