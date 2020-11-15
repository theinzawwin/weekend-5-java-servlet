package com.best.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.best.jee.model.Grade;
import com.best.jee.model.Student;

public class GradeDao {

	public String dbConnection="jdbc:mysql://localhost:3306/best5db";
	public boolean saveGrade(Grade grade) throws Exception {
		String sql="insert into grade(name,teacher_name) values(?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					dbConnection,"root","root");  
				java.sql.PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setString(1, grade.getName());
				pstmt.setString(2, grade.getTeacherName());
				
				int status=pstmt.executeUpdate();
				if(status>0)
					return true;
				else
					return false;
		}catch(Exception ex) {
			throw ex;
		}
		
	}
	public List<Grade> getGradeList() throws Exception{
		List<Grade> gradeList= new ArrayList<Grade>();
		String sql="select * from Grade";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/best5db","root","root"); 
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				Grade std=new Grade(rs.getLong("id"), rs.getString("name"), rs.getString("teacher_name"));
				gradeList.add(std);
			}
			return gradeList;
		}catch(Exception ex) {
			throw ex;
		}
	}
}
