package com.restful.livetv.model.movie;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class movie {
	private int movie_id;
	private String movie_name;
	private String movice_pic;
	private int movie_length;
	private int movie_year;
	private String movie_summary;
	private List<cast> casts = new ArrayList<>();
	private List<genre> genres = new ArrayList<>();
	
	public movie(){}
	
	public movie(int movie_id,String movie_name,String movice_pic,int movie_length,int movie_year,String movie_summary){
		this.movie_id = movie_id;
		this.movie_name = movie_name;
		this.movice_pic = movice_pic;
		this.movie_length = movie_length;
		this.movie_year = movie_year;
		this.movie_summary = movie_summary;
	}
	public int getmovie_id(){
		return movie_id;
	}
	public void setmovie_id(int movie_id){
		this.movie_id = movie_id;
	}
	
	public String getmovie_name(){
		return movie_name;
	}
	public void setmovie_name(String movie_name){
		this.movie_name = movie_name;
	}
	
	public String getmovice_pic(){
		return movice_pic;
	}
	public void setmovice_pic(String movice_pic){
		this.movice_pic = movice_pic;
	}
	
	public int getmovie_length(){
		return movie_length;
	}
	public void setmovie_length(int movie_length){
		this.movie_length = movie_length;
	}
	
	public int getmovie_year(){	
		return movie_year;
	}
	public void setmovie_year(int movie_year){
		this.movie_year = movie_year;
	}
	
	public String getmovie_summary(){
		return movie_summary;
	}
	public void setmovie_summary(String movie_summary){
		this.movie_summary = movie_summary;
	}
	
	public List<cast> getmovie_casts() {
		return casts;
	}
	public void setmovie_casts(List<cast> casts) {
		this.casts = casts;
	}
	
	public void addmovie_cast(int movie_id,int people_id,String name){
		cast cast = new cast();
		cast.setmovie_id(movie_id);
		cast.setpeople_id(people_id);
		cast.setcast_name(name);
		casts.add(cast);
	}
	
	public List<genre> getmovie_genres() {
		return genres;
	}
	public void setmovie_genres(List<genre> genres) {
		this.genres = genres;
	}
	
	public void addmovie_genre(int movie_id,int genre_id,String genre_name){
		genre genre = new genre();
		genre.setmovie_id(movie_id);
		genre.setgenre_id(genre_id);
		genre.setgenre_name(genre_name);
		genres.add(genre);
	}
}
