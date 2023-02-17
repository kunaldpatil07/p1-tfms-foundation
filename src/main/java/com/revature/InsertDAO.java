package com.revature;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertDAO {
	public int k=0;
	public int insert(QuestionBean bbn) {
		try {
			Connection con=DataBaseConnection.getConnection();
			PreparedStatement ps= con.prepareStatement("insert into QuestionManagement values(?,?,?)");
			ps.setString(1, bbn.getquestionId());
			ps.setString(2,bbn.getQuestionSection());
//			ps.setInt(3, bbn.getTotalSeats());
			ps.setString(4, bbn.getQuestionText());
			k= ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return k;
	}

}
