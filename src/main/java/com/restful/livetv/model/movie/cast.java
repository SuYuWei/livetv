package com.restful.livetv.model.movie;

public class cast {
	private int movie_id;
	private int people_id;
	private String cast_name;
	public cast(){}
	
	public cast(int movie_id,int people_id,String cast_name){
		this.movie_id = movie_id;
		this.people_id = people_id;
		this.cast_name = cast_name;
	}
	
	public int getmovie_id(){
		return movie_id;
	}
	public void setmovie_id(int movie_id){
		this.movie_id = movie_id;
	}
	
	public int getpeople_id(){
		return people_id;
	}
	public void setpeople_id(int people_id){
		this.people_id = people_id;
	}
	
	public String getcast_name(){
		return cast_name;
	}
	public void setcast_name(String cast_name){
		this.cast_name = cast_name;
	}
	
	

}
