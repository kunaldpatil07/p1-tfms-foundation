package com.revature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RetriveDAO {
	public ArrayList<QuestionBean> al= new ArrayList<QuestionBean>();
	public ArrayList<QuestionBean> retrieve(){
		try {
		Connection con = DataBaseConnection.getConnection();
		PreparedStatement ps= con.prepareStatement("select*from QuestionManagement");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			QuestionBean bb1= new QuestionBean();
			bb1.setquestionId(rs.getString(1));
			bb1.setQustionSection(rs.getString(2));
			//bb1.setTotalSeats(rs.getInt(3));
			bb1.setQuestionText(rs.getString(4));
			
			al.add(bb1);
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return al;
	}
}
