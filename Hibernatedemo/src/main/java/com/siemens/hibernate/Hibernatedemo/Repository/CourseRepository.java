package com.siemens.hibernate.Hibernatedemo.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.siemens.hibernate.Hibernatedemo.Entity.Course;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	private EntityManager em;
	
    public Course findById(long id){
    	return em.find(Course.class, id);
    }
    
    public Course save(Course c){
    	if ( c.getId() == null){
    		// create case
    		 em.persist(c);
    	}else{
    		// update case
    		 em.merge(c);
    	}
    	return c;
    }
    
    public void deleteById(long id){
    	em.remove(findById(id));
    }
}
