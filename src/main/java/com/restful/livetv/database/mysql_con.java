package com.restful.livetv.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mysql_con {
	
			Connection con = null;	//�s��
		
	public static Connection ConnecrDb(){
			try { 
			      Class.forName("com.mysql.jdbc.Driver");      //���Udriver 
			      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=Big5","root","test");
			    //localhost�O�D���W,test�Odatabase�W					http://192.168.1.103/phpmyadmin  root test  mysql test test  108:radius radpass
			      
			    //useUnicode=true&characterEncoding=Big5�ϥΪ��s�X
			      return con;
			    } 
			    catch(ClassNotFoundException e) 
			    { 
			      System.out.println("DriverClassNotFound :"+e.toString()); 
			      return null;
			    }
			    catch(SQLException x) { 
			      System.out.println("Exception :"+x.toString()); 
			      return null;
			    }			
	}
}
