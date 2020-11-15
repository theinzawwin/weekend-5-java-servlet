package com.best.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.best.jee.model.Student;

public class StudentDao {

	
	public boolean saveStudent(Student std) throws Exception {
		

		String sql="insert into student(name,nrc,address,rollno) values(?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/best5db","root","root");  
				java.sql.PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setString(1, std.getName());
				pstmt.setString(2, std.getNrc());
				pstmt.setString(3,std.getAddress());
				pstmt.setNString(4, std.getRollNo());
				int status=pstmt.executeUpdate();
				if(status>0)
					return true;
				else
					return false;
		}catch(Exception ex) {
			throw ex;
		}
			
	}
	public List<Student> getStudentList() throws Exception{
		List<Student> studentList= new ArrayList<Student>();
		String sql="select * from Student";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/best5db","root","root"); 
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				Student std=new Student(rs.getLong("id"), rs.getString("name"), rs.getString("nrc"), rs.getString("address"), rs.getString("rollno"));
				studentList.add(std);
			}
			return studentList;
		}catch(Exception ex) {
			throw ex;
		}
		
	}
	
}
