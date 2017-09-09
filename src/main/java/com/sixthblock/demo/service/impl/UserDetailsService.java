package com.sixthblock.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sixthblock.demo.dao.IUserDetailsDAO;
import com.sixthblock.demo.entity.UserDetails;
import com.sixthblock.demo.service.IUserDetailsService;

@Service
public class UserDetailsService implements IUserDetailsService{
	@Autowired
	private IUserDetailsDAO userDetailsDAO;
	@Override
	public UserDetails getUserDetailsById(int userDetailsId) {
		UserDetails obj = userDetailsDAO.getUserDetailsById(userDetailsId);
		return obj;
	}	
	@Override
	public List<UserDetails> getAllUserDetailss(){
		return userDetailsDAO.getAllUserDetailss();
	}
	@Override
	public synchronized boolean addUserDetails(UserDetails userDetails){
       if (userDetailsDAO.userDetailsExists(userDetails.getUsername(), userDetails.getEmail())) {
    	   return false;
       } else {
    	   userDetailsDAO.addUserDetails(userDetails);
    	   return true;
      }
	}
	@Override
	public void updateUserDetails(UserDetails userDetails) {
		userDetailsDAO.updateUserDetails(userDetails);
	}
	@Override
	public void deleteUserDetails(int userDetailsId) {
		userDetailsDAO.deleteUserDetails(userDetailsId);
	}
	@Override
	public UserDetails validateUser(String username, String password) {
		return userDetailsDAO.validateUser(username, password);
	}
}
