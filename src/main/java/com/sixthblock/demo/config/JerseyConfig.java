package com.sixthblock.demo.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.sixthblock.demo.endpoint.UserDetailsEndPoint;

@Component
@ApplicationPath("/sixthblock")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(UserDetailsEndPoint.class);
	}
}
