package com.tech.pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Student {
	
	//step1:initialize the interfaces with null values
	private static Connection cn=null;
	private static Statement stm=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	
	//step2:initialize the url,username,password
	String url="jdbc:mysql://localhost:3306/palle";
	String username="root";
	String password="admin";
	//step3:write the sql queries by initializing with variables below
	String createqry="create table student(sno int primary key auto_increment,sname varchar(40),sub varchar(40),email varchar(30))";
	String insertqry="insert into student(sname,sub,email)values(?,?,?)";
	String updateqry="update student set email=?,sub=? where sno=?";
	String deleteqry="delete from student where sno=?";
	String readqry="select * from student";
	public void creating()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection(url, username, password);
			stm=cn.createStatement();
			stm.executeUpdate(createqry);
			System.out.println("database connected and table created in the database");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(stm!=null)
			{
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(cn!=null)
			{
				try {
					cn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void inserting(String sname,String sub,String email)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection(url, username, password);
			ps=cn.prepareStatement(insertqry);
			ps.setString(1, sname);
			ps.setString(2,sub);
			ps.setString(3, email);
			ps.executeUpdate();
			System.out.println("data inserted into the database!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null)
			{
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(cn!=null)
			{
				try {
					cn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void update(int sno,String email,String sub)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection(url, username, password);
			ps=cn.prepareStatement(updateqry);
			ps.setString(1, email);
			ps.setString(2, sub);
			ps.setInt(3, sno);
			ps.executeUpdate();
			System.out.println("data updated in the database");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null)
			{
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(cn!=null)
			{
				try {
					cn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void delete(int sno)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection(url, username, password);
			ps=cn.prepareStatement(deleteqry);
			ps.setInt(1, sno);
			ps.executeUpdate();
			System.out.println("data deleted from the database");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null)
			{
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(cn!=null)
			{
				try {
					cn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void read()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection(url, username, password);
			stm=cn.createStatement();
			rs=stm.executeQuery(readqry);
			System.out.println("reading data from the database");
			while(rs.next()==true)
			{
				System.out.println("sno:"+rs.getInt(1));
				System.out.println("sname:"+rs.getString(2));
				System.out.println("sub:"+rs.getString(3));
				System.out.println("email:"+rs.getString(4));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stm!=null)
			{
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(cn!=null)
			{
				try {
					cn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
