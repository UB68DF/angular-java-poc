package com.sixthblock.demo.endpoint;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sixthblock.demo.entity.UserDetails;
import com.sixthblock.demo.service.IUserDetailsService;

@Component
@Path("/userdetails")
public class UserDetailsEndPoint {
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsEndPoint.class);	
	@Autowired
	private IUserDetailsService userDetailsService;
	
	@POST
	@Path("/auth")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginCheck(UserDetails ud) {
        UserDetails user = userDetailsService.validateUser(ud.getUsername(), ud.getPassword());
        if (user == null) {
        	logger.info("UserDetails already exits.");
	        return Response.status(Status.CONFLICT).build();
        }else{
        	return Response.ok(user).build();
        }
	}	
	
	@GET
	@Path("/details")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserDetailsDetails() {
		List<UserDetails> list = userDetailsService.getAllUserDetailss(); 
		return Response.ok(list).build();
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserDetailsById(@PathParam("id") Integer id) {
		UserDetails userDetails = userDetailsService.getUserDetailsById(id);
		return Response.ok(userDetails).build();
	}
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUserDetails(UserDetails userDetails) {
        boolean isAdded = userDetailsService.addUserDetails(userDetails);
        if (!isAdded) {
        	logger.info("UserDetails already exits.");
	        return Response.status(Status.CONFLICT).build();
        }
        return Response.created(URI.create("/spring-app/userdetails/"+ userDetails.getId())).build();
	}	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)	
	public Response updateUserDetails(UserDetails userDetails) {
		userDetailsService.updateUserDetails(userDetails);
		return Response.ok(userDetails).build();
	}
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)		
	public Response deleteUserDetails(@PathParam("id") Integer id) {
		userDetailsService.deleteUserDetails(id);
		return Response.noContent().build();
	}	
}
