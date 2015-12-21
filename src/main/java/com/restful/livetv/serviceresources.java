package com.restful.livetv;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/service")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class serviceresources {
	
	@Path("/tvshow")
	public tvshowresources gettvshow(){
		return new tvshowresources();
	}
	
	@Path("/movie")
	public movieresources getmovie(){
		return new movieresources();
	}
}
