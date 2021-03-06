package com.siemens.hibernate.Hibernatedemo.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.siemens.hibernate.Hibernatedemo.Entity.Course;
import java.util.*;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	private EntityManager em;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
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
    
    public void playwithEntityManager(){
    	Course c1 = new Course("I");
    	Course c2 = new Course("II");
    	
    	em.persist(c1);
    	em.persist(c2);
    	
    	em.flush();
    	
        c1.setName("I updated");
        c2.setName("II - updated");
        
        em.refresh(c1);
        em.flush();
    	
    }
    
    public void Basic_JPQLQuery(){
    	     List ret =    em.createQuery("select c from Course c").getResultList();
    	     logger.info("creating query -> {}", ret);
    }
}
