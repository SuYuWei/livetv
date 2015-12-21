package com.restful.livetv.model.tvshow;

import java.sql.Date;
import java.sql.Time;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class tvshow {
	private Date play_date;
	private String play_name;
	private Time start_time;
	private Time end_time;
	
	public tvshow(){}
	
	public tvshow(Date play_date,String play_name,Time start_time,Time end_time){
		this.play_date = play_date;
		this.play_name = play_name;
		this.start_time = start_time;
		this.end_time = end_time;
	}
	
	public Date getdate(){
		return play_date;
	}
	public void setdate(Date play_date){
		this.play_date = play_date;
	}
	
	public String getname(){
		return play_name;
	}
	public void setname(String play_name){
		this.play_name = play_name;
	}
	
	public Time getstime(){
		return start_time;
	}
	public void setstime(Time start_time){
		this.start_time = start_time;
	}
	
	public Time getetime(){
		return end_time;
	}
	public void setetime(Time end_time){
		this.end_time = end_time;
	}
}
