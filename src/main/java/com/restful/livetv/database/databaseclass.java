package com.restful.livetv.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.json.JsonArray;

import com.restful.livetv.jsontest;
import com.restful.livetv.model.movie.cast;
import com.restful.livetv.model.movie.movie;
import com.restful.livetv.model.movie.genre;
import com.restful.livetv.model.tvshow.tvshow;


public class databaseclass {
	
	//private static Map<String,tvshow> tvshow = new HashMap<>();
	private Connection con = mysql_con.ConnecrDb();	//連接
	private Statement stat = null;  //執行
	private ResultSet rs = null;  	//結果
	private PreparedStatement pst = null;
	List<tvshow> tvshowlist = new ArrayList<>();
	List<movie> movielist = new ArrayList<>();
	List<cast> castlist = new ArrayList<>();
	List<genre> genrelist = new ArrayList<>();
	private Calendar cal = Calendar.getInstance();
	jsontest json = new jsontest();
	
	/*public static void Main(String[]args){
		databaseclass n = new databaseclass();
		n.inserttvshow();
	}
	
	public static Map<String,tvshow> gettvshow(){
		return tvshow;
	}*/
	
	public List<tvshow> tvshowdatabaseclass(){
		try { 		     						
				String selectSQL = "select * from test";      
				pst = con.prepareStatement(selectSQL);
				rs = pst.executeQuery();   			
				while (rs.next()) {
					//rs.getString("start_time");
					//rs.getTime("end_time");
					//DateFormat formatter = new SimpleDateFormat("HH:mm");
					//Time time = new Time(formatter.parse(rs.getString("start_time")).getTime());
					tvshowlist.add(new tvshow(rs.getDate("play_date"),rs.getString("play_name"),rs.getTime("start_time"),rs.getTime("end_time")));
			    }		    
		} 
		catch(SQLException x){ 
		      System.out.println("Exception :"+x.toString()); 
		} 
		finally{ 
		      Close(); 
		}
		return tvshowlist;
	}
	
	public List<movie> moviedatabaseclass(){
		try { 		     						
				String selectSQL = "select * from movie";      
				pst = con.prepareStatement(selectSQL);
				rs = pst.executeQuery(); 
							
				while (rs.next()) {
					cal.setTime(rs.getDate("movie_year"));	//get Year of Date				
					movielist.add(new movie(rs.getInt("movie_id"),rs.getString("movie_name"),rs.getString("movie_pic"),rs.getInt("movie_length"),cal.get(Calendar.YEAR),rs.getString("movie_summary")));
			    }		    
		} 
		catch(SQLException x){ 
		      System.out.println("Exception :"+x.toString()); 
		} 
		finally{ 
		      Close(); 
		}
		return movielist;
	}
	
	public List<cast> moviedatabasecast(){
		try { 		     						
				String selectSQL = "select * from cast";      
				pst = con.prepareStatement(selectSQL);
				rs = pst.executeQuery(); 						
				while (rs.next()) {
					castlist.add(new cast(rs.getInt("movie_id"),rs.getInt("people_id"),rs.getString("cast_name")));
			    }		    
		} 
		catch(SQLException x){ 
		      System.out.println("Exception :"+x.toString()); 
		} 
		finally{ 
		      Close(); 
		}
		return castlist;
	}
	
	public List<genre> moviedatabasegenre(){
		try { 		     						
				String selectSQL = "select * from genre";      
				pst = con.prepareStatement(selectSQL);
				rs = pst.executeQuery(); 						
				while (rs.next()) {
					genrelist.add(new genre(rs.getInt("movie_id"),rs.getInt("genre_id"),rs.getString("genre_name")));
			    }		    
		} 
		catch(SQLException x){ 
		      System.out.println("Exception :"+x.toString()); 
		} 
		finally{ 
		      Close(); 
		}
		return genrelist;
	}
	
	
	public void inserttvshow(){
		JsonArray ary = json.getjosn();
		try {
			String insertSQL = "insert into test1 (pdate, name, stime , etime) value (?,?,?,?)";
			//String insertSQL = "insert into test1 (pdate, name, stime , etime) value ("+ary.getJsonObject(0).get("Date").toString()+","+ary.getJsonObject(0).get("P_Name").toString()+","+ary.getJsonObject(0).get("S_time").toString()+","+ary.getJsonObject(0).get("E_time").toString()+")"; 
			pst = con.prepareStatement(insertSQL);
			for(int i=0;i < ary.size();i++){
				pst.setString(1, ary.getJsonObject(i).get("Date").toString().replaceAll("\"", ""));
				pst.setString(2, ary.getJsonObject(i).get("P_Name").toString().replaceAll("\"", ""));
				pst.setString(3, ary.getJsonObject(i).get("S_time").toString().replaceAll("\"", ""));
				pst.setString(4, ary.getJsonObject(i).get("E_time").toString().replaceAll("\"", ""));
				pst.executeUpdate();
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{ 
		      Close(); 
		}
	}
	private void update(){
		
	}
	private void delete(){
		
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
