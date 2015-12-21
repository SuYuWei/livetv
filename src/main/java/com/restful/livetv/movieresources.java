package com.restful.livetv;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.restful.livetv.model.movie.movie;
import com.restful.livetv.model.tvshow.tvshow;
import com.restful.livetv.service.movieservice;


@Path("/")	
@Produces(MediaType.APPLICATION_JSON)
public class movieresources {
	
	movieservice movieservice = new movieservice();
	
	@GET
	public List<movie> getallmovie(@QueryParam("id") int id){
		if(id > 0){
			return movieservice.getmovieid(id);
		}
		return movieservice.getAllmovie();
	}
	
	/*@GET
	@Path("id/{value}")
	public movie getmoviebyid(@PathParam("value") int id ,@Context UriInfo uriInfo){
		/*movie movie = movieservice.getmovie(id);
		String uri = uriInfo.getBaseUriBuilder()	//http://localhost:8080/livetv/webapi
		.path(movieresources.class)								//  /movie
		.path(Integer.toString(movie.getid()))						//	/{value}
		.build()
		.toString();
		movie.addcast(1,uri);//
		return movieservice.getmovie(id);	
		//return movieservice.getmovieid(id)		
	}*/
	
	@GET
	@Path("{cname}")
	public movie getmoviebyclass(@QueryParam("id") int id,@PathParam("cname") String cname){
		/*if(cname.equals("cast")){
		return movieservice.getcname(id);	
		}
		if(cname.equals("genre")){
			return movieservice.getgname(id);	
		}*/
		return movieservice.getname(id, cname);	
	}
}
