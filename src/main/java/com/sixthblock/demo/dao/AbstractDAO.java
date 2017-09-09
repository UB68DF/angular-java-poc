package com.sixthblock.demo.dao;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

//@EnableTransactionManagement
//@Transactional
public abstract class AbstractDAO<T> {/*
	
		//private final Class<T> persistentClass;
		@Autowired
		protected HibernateTemplate  hibernateTemplate;
		@Autowired
		protected NamedParameterJdbcTemplate namedJdbcTemplate;
		@Autowired
		protected JdbcTemplate jdbcTemplate;

		@SuppressWarnings("unchecked")
		public AbstractAmcDao(){
			this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}

		@SuppressWarnings("unchecked")
		public T getByKey(Class<?> clas, Serializable key) {
			return (T) hibernateTemplate.get(clas, key);
		}

		public void persist(T entity) {
			hibernateTemplate.persist(entity);
		}
		
		public Object save(T entity) {
			return hibernateTemplate.save(entity);
		}
		
		public void saveOrUpdate(T entity) {
			hibernateTemplate.saveOrUpdate(entity);
		}
		
		public void update(T entity) {
			hibernateTemplate.update(entity);
		}
		
		public void merge(T entity) {
			hibernateTemplate.merge(entity);
		}

		public void delete(T entity) {
			hibernateTemplate.delete(entity);
		}


*/}
