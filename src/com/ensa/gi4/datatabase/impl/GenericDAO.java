package com.ensa.gi4.datatabase.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ensa.gi4.modele.User;

import javax.sql.DataSource;
import java.util.List;

public abstract class GenericDAO<T> implements InitializingBean {
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    
    
    
    
    @Override
    public void afterPropertiesSet() { // from InitializingBean
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    protected List<T> findAll(String query) {
       try { return jdbcTemplate.query(query, getRowMapper());
       
       }catch(Exception e){
    	   return null;
       }
    }

    
       
    protected T executeQuery(String query) {
    	try {
        return jdbcTemplate.queryForObject(query, getRowMapper());
    	} catch (Exception e) {
    		return null;
    	}
    } 
   
     protected void UpdateQuery(String query) {
    	 
    	 jdbcTemplate.update(query);
    	 
     }
    protected T findOne(String query, Long id) {
       try { return jdbcTemplate.queryForObject(query, getRowMapper(), id);
       
       }catch(Exception e) {
    	   return null;
       }
    }
    

 protected String executeForString2(String query) {
    	
    	
     return this.jdbcTemplate.queryForObject(query, String.class);
    	
    }
    protected String executeForString(String query,String name) {
    	
    	try {
    		return (String) jdbcTemplate.queryForObject(query,new Object[] {name}, String.class);
    	}catch(Exception e) {
    		return null;
    	}
    }
 
    
    protected int executeForInt( String query){
    	
    	return this.jdbcTemplate.queryForObject(query,Integer.class);
    }
   protected int executeWithVerif(String query) {
	   return this.jdbcTemplate.update(query);
   }
    
    protected abstract RowMapper<T> getRowMapper();
    protected T findOne(String query, String name,String password) {
        try{return jdbcTemplate.queryForObject(query, getRowMapper(), name,password);
        
        }catch(Exception e) {
        	return null;
        }
    }
    
    
}
