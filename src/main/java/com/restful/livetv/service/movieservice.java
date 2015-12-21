package com.restful.livetv.service;

import java.util.ArrayList;
import java.util.List;

import com.restful.livetv.database.databaseclass;
import com.restful.livetv.model.movie.cast;
import com.restful.livetv.model.movie.genre;
import com.restful.livetv.model.movie.movie;


public class movieservice {
	
	databaseclass db = new databaseclass();
	List<movie> list = db.moviedatabaseclass();
	List<cast> listcast = db.moviedatabasecast();
	List<genre> listgenre = db.moviedatabasegenre();
	
	public List<movie> getAllmovie(){
		return list;		
	}
	
	public List<movie> getmovieid(int id){
		List<movie> movieforid = new ArrayList<>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getmovie_id() == id){
				movieforid.add(list.get(i));
			}
		}		
		return movieforid;		
	}
	
	public movie getmovie(int id){
		List<movie> movieforid = new ArrayList<>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getmovie_id() == id){
				movieforid.add(list.get(i));
			}
		}		
		return movieforid.get(0);		
	}
	
	public movie getname(int id,String name){
		List<movie> movielist = new ArrayList<>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getmovie_id() == id){
				movielist.add(list.get(i));
			}
		}
		movie movie = movielist.get(0);
		
		if(name.equals("cast")){
			for(int i=0;i<listcast.size();i++){
				if(id == listcast.get(i).getmovie_id()){
					movie.addmovie_cast(listcast.get(i).getmovie_id(),listcast.get(i).getpeople_id(), listcast.get(i).getcast_name());
				}		
			}	
			return movie;
		}
		else if(name.equals("genre")){
			for(int i=0;i<listgenre.size();i++){
				if(id == listgenre.get(i).getmovie_id()){
					movie.addmovie_genre(listgenre.get(i).getmovie_id(),listgenre.get(i).getgenre_id(), listgenre.get(i).getgenre_name());
				}		
			}
			return movie;	
		}
		return null;	
	}
	
	/*public movie getcname(int id){
		List<movie> movieforid = new ArrayList<>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getid() == id){
				movieforid.add(list.get(i));
			}
		}
		movie movie = movieforid.get(0);
		
		for(int i=0;i<listcast.size();i++){
			if(id == listcast.get(i).getmovie_id()){
				movie.addcast(listcast.get(i).getmovie_id(),listcast.get(i).getpeople_id(), listcast.get(i).getcast_name());
			}		
		}	
		return movie;	
	}
	
	public movie getgname(int id){
		List<movie> movieforid = new ArrayList<>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getid() == id){
				movieforid.add(list.get(i));
			}
		}
		movie movie = movieforid.get(0);
		
		for(int i=0;i<listgenre.size();i++){
			if(id == listgenre.get(i).getmovie_id()){
				movie.addgenre(listgenre.get(i).getmovie_id(),listgenre.get(i).getgenre_id(), listgenre.get(i).getgenre_name());
			}		
		}	
		return movie;	
	}*/
}
