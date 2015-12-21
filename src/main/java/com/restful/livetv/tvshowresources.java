package com.restful.livetv;



import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.restful.livetv.database.databaseclass;
import com.restful.livetv.model.tvshow.tvshow;
import com.restful.livetv.service.tvshowservice;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class tvshowresources {
	
	tvshowservice tvshowservice = new tvshowservice();
	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@GET
	public List<tvshow> getalltvshow(@QueryParam("date") Date date,
									 @QueryParam("name") String name,
									 @QueryParam("stime") Time stime,
									 @QueryParam("etime") Time etime){
		if(date != null){		
			return tvshowservice.gettvshowfordate(date);
		}
		if(name != null){
			return tvshowservice.gettvshowforname(name);
		}
		if(stime != null && etime != null){
			return tvshowservice.gettvshowfortime(stime,etime);
		}	
		return tvshowservice.getAlltvshow();
	}
	
	@POST
	public String addmessage(){
		databaseclass db = new databaseclass();
		db.inserttvshow();
		return "insert data";
	}
	
	/*@PUT
	@Path("/{value}")
	public tvshow updatemessage(@PathParam("value") String value,tvshow tvshow){
		tvshow.setname(value);
		return tvshowservice.updatetvshow(tvshow);
	}
	
	@DELETE
	@Path("/{value}")
	public tvshow removemessage(@PathParam("value") String value){
		return tvshowservice.removetvshow(value);
	}*/
	
	@GET
	@Path("/{value}")
	public List<tvshow> gettvshowmessagebyname(@PathParam("value") String value){
		return tvshowservice.gettvshowforname(value);
	}
	
}
