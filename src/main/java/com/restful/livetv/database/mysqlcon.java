package com.restful.livetv.database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class mysqlcon {
	
	private Connection con = null;	//連接
	private Statement stat = null;  //執行
	private ResultSet rs = null;  	//結果
	private PreparedStatement pst = null;
	private int numberOfColumns = 0;	//欄位數
	private int numberOfRows = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mysqlcon my = new mysqlcon();		
	}
	public mysqlcon(){
		con = mysql_con.ConnecrDb();
		try 
		{ 		     						
				String selectSQL = "select * from livetv";      
				pst = con.prepareStatement(selectSQL);
				rs = pst.executeQuery();   			
		      	ResultSetMetaData metaData = rs.getMetaData();
		      	//抓資料庫欄位筆數，存在numberOfColumns
			    numberOfColumns = metaData.getColumnCount();
			    //抓資料庫資料筆數，存在numberOfRows
			    rs.last();		      
			    numberOfRows = rs.getRow();
				rs.beforeFirst();
				
				System.out.println(numberOfColumns);
				System.out.println(numberOfRows);
				
				Vector<String> columnNames = new Vector<String>();
				Vector<Vector<String>> rows = new Vector<Vector<String>>();
							
			    while (rs.next()) {			    	
				    Vector<String> newRow = new Vector<String>();			    
					for (int i = 1; i <= numberOfColumns; i++) {
					    newRow.addElement(rs.getString(i));
					}					
					rows.addElement(newRow);
			    }
			    System.out.println(rows);
		} 
		catch(SQLException x){ 
		      System.out.println("Exception :"+x.toString()); 
		}
		finally{ 
	      Close(); 
	    }
	}
	private void Close(){ 
	    try{ 
	      if(rs!=null){ 
	        rs.close(); 
	        rs = null; 
	      } 
	      if(stat!=null){ 
	        stat.close(); 
	        stat = null; 
	      } 
	      if(pst!=null){ 
	        pst.close(); 
	        pst = null; 
	      } 
	    } 
	    catch(SQLException e){ 
	      System.out.println("Close Exception :" + e.toString()); 
	    } 
	}
}
