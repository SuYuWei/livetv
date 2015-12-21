package com.restful.livetv.model.movie;

public class genre {
	private int movie_id;
	private int genre_id;
	private String genre_name;
	
	public genre(){}
	
	public genre(int movie_id,int genre_id,String genre_name){
		this.movie_id = movie_id;
		this.genre_id = genre_id;
		this.genre_name = genre_name;
	}
	
	public int getmovie_id(){
		return movie_id;
	}
	public void setmovie_id(int movie_id){
		this.movie_id = movie_id;
	}
	
	public int getgenre_id(){
		return genre_id;
	}
	public void setgenre_id(int genre_id){
		this.genre_id = genre_id;
	}
	
	public String getgenre_name(){
		return genre_name;
	}
	public void setgenre_name(String genre_name){
		this.genre_name = genre_name;
	}
}
