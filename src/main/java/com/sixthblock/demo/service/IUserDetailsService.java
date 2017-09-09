package com.sixthblock.demo.service;

import java.util.List;

import com.sixthblock.demo.entity.UserDetails;

public interface IUserDetailsService {
	UserDetails validateUser(String username, String password);
    List<UserDetails> getAllUserDetailss();
    UserDetails getUserDetailsById(int userDetailsId);
    boolean addUserDetails(UserDetails userDetails);
    void updateUserDetails(UserDetails userDetails);
    void deleteUserDetails(int userDetailsId);
}
