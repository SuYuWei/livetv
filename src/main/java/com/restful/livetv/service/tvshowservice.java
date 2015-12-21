package com.restful.livetv.service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.restful.livetv.database.databaseclass;
import com.restful.livetv.model.tvshow.tvshow;


public class tvshowservice {
	
	//private static Map<String,tvshow> tvshows = databaseclass.gettvshow();
	databaseclass db = new databaseclass();
	List<tvshow> list = db.tvshowdatabaseclass();
	
	/*public tvshowservice(){
		tvshows.put("ccc",new tvshow(new Date(20151104),"ccc",new Time (1730),new Time (1730)));
		tvshows.put("海賊王",new tvshow(new Date(20151104),"海賊王",new Time (1800),new Time (1830)));
		tvshows.put("通靈王",new tvshow(new Date(20151104),"通靈王",new Time (1800),new Time (1830)));
	}*/
	
	public List<tvshow> getAlltvshow(){
		/*tvshow s1 = new tvshow(new Date(1111111),"北海小英雄",new Time (1730),new Time (1730));
		tvshow s2 = new tvshow(new Date(1111111),"海賊王",new Time (1800),new Time (1830));
		List<tvshow> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		return list;*/
		//return new ArrayList<tvshow>(tvshows.values());
		return list;
	}
	
	public List<tvshow>	gettvshowfordate(Date date){
		List<tvshow> tvshowfordate = new ArrayList<>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getdate().equals(date)){
				tvshowfordate.add(list.get(i));
			}
		}
		return tvshowfordate;			
	}
	
	public List<tvshow>	gettvshowforname(String name){
		List<tvshow> tvshowforname = new ArrayList<>();
		
		for(int i=0;i<list.size();i++){
			if(list.get(i).getname().equals(name)){
				tvshowforname.add(list.get(i));
			}
		}
		/*for(tvshow tvshow : tvshows.values()){
			if(tvshow.getname() == name){
				tvshowforname.add(tvshow);
			}
		}*/
		return tvshowforname;			
	}
	
	public List<tvshow>	gettvshowfortime(Time stime,Time etime){
		List<tvshow> tvshowfortime = new ArrayList<>();
		for(int i=0;i<list.size();i++){
			if((list.get(i).getstime().after(stime) || list.get(i).getstime().equals(stime)) && (list.get(i).getetime().before(etime) || list.get(i).getetime().equals(etime))){
				tvshowfortime.add(list.get(i));
			}
		}
		return tvshowfortime;			
	}
	/*public tvshow gettvshow(String play_name){
		for(int i=0;i<list.size();i++){
			if(list.get(i).getname().equals(play_name)){
				return list.get(i);				
			}
		}
		return null;
	}*/
	
	/*public tvshow addtvshow(tvshow tvshow){
		tvshows.put(tvshow.getname(),tvshow);
		return tvshow;	
	}
	
	public tvshow updatetvshow(tvshow tvshow){
		tvshows.put(tvshow.getname(),tvshow);
		return tvshow;	
	}
	
	public tvshow removetvshow(String play_name){
		return tvshows.remove(play_name);
	}*/
	
}
