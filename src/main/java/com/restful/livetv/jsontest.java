package com.restful.livetv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.json.JSONArray;

import com.restful.livetv.database.mysql_con;

public class jsontest {
	private URL url;
	private InputStream is;
	private JsonReader rdr;
	private JsonArray ary;
	private Connection con = mysql_con.ConnecrDb();	//連接
	private Statement stat = null;  //執行
	private ResultSet rs = null;  	//結果
	private PreparedStatement pst = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jsontest j = new jsontest();
		j.getjosn();
	}
	
	public JsonArray getjosn(){
		
		try {
			url = new URL("http://123.51.170.209/skyking/api/Channel_List.aspx?action=cartoon");
			is = url.openStream();
			rdr = Json.createReader(is);
			//JsonObject obj = rdr.readObject();
			ary = rdr.readArray();
			
			/*for(int i=0;i < ary.size();i++){
				System.out.println(ary.getJsonObject(i).get("Date"));
				System.out.println(ary.getJsonObject(i).get("P_Name"));
				System.out.println(ary.getJsonObject(i).get("S_time"));
				System.out.println(ary.getJsonObject(i).get("E_time"));
			}
			
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
			*/
			//System.out.println(ary.getJsonObject(0).get("Date"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{ 
		      Close(); 
		}
		return ary;
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
