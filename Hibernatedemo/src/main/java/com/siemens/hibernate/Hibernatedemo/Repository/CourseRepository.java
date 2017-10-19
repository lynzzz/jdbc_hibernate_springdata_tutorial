package com.siemens.hibernate.Hibernatedemo.Repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.siemens.hibernate.Hibernatedemo.Entity.Course;

@Repository
public class CourseRepository {

	@Autowired
	private EntityManager em;
	
    public Course findById(long id){
    	return em.find(Course.class, id);
    }
    
    public Course save(Course c){
    	return em.merge(c);
    }
    
    public void deleteById(long id){
    	em.remove(findById(id));
    }
}
