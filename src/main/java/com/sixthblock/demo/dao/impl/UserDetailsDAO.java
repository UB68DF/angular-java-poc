package com.sixthblock.demo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sixthblock.demo.dao.AbstractDAO;
import com.sixthblock.demo.dao.IUserDetailsDAO;
import com.sixthblock.demo.entity.UserDetails;

@Transactional
@Repository
public class UserDetailsDAO extends AbstractDAO<UserDetails> implements IUserDetailsDAO{
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public UserDetails validateUser(String username, String password) {
		UserDetails ud = null;
		String hql = "from UserDetails as ud where ud.username = ? and ud.password = ?";
		List<UserDetails> udlist = entityManager.createQuery(hql).setParameter(1, username)
		              .setParameter(2, password).getResultList();
		if(udlist.size()>0){
			ud = udlist.get(0);
		}
		return ud;
	}
	@Override
	public UserDetails getUserDetailsById(int userDetailsId) {
		return entityManager.find(UserDetails.class, userDetailsId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<UserDetails> getAllUserDetailss() {
		String hql = "FROM UserDetails as atcl ORDER BY atcl.id";
		return (List<UserDetails>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addUserDetails(UserDetails userDetails) {
		entityManager.persist(userDetails);
	}
	@Override
	public void updateUserDetails(UserDetails userDetails) {
		UserDetails artcl = getUserDetailsById(userDetails.getId());
		entityManager.flush();
	}
	@Override
	public void deleteUserDetails(int userDetailsId) {
		entityManager.remove(getUserDetailsById(userDetailsId));
	}
	@Override
	public boolean userDetailsExists(String username, String email) {
		String hql = "FROM UserDetails as ud WHERE ud.username = ? or ud.email = ?";
		int count = entityManager.createQuery(hql).setParameter(1, username)
		              .setParameter(2, email).getResultList().size();
		return count > 0 ? true : false;
	}
}
