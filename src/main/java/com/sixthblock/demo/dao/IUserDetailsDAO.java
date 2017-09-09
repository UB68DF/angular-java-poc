package com.sixthblock.demo.dao;

import java.util.List;

import com.sixthblock.demo.entity.UserDetails;

public interface IUserDetailsDAO {
	
	public UserDetails validateUser(String username, String password);
	 List<UserDetails> getAllUserDetailss();
	    UserDetails getUserDetailsById(int userDetailsId);
	    void addUserDetails(UserDetails userDetails);
	    void updateUserDetails(UserDetails userDetails);
	    void deleteUserDetails(int userDetailsId);
		public boolean userDetailsExists(String username, String email);

}
