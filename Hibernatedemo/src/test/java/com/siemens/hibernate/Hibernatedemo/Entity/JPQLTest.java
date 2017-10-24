package com.siemens.hibernate.Hibernatedemo.Entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.siemens.hibernate.Hibernatedemo.HibernatedemoApplication;
import com.siemens.hibernate.Hibernatedemo.Entity.Course;
import com.siemens.hibernate.Hibernatedemo.Repository.CourseRepository;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=HibernatedemoApplication.class)
public class JPQLTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
    @Autowired
    EntityManager em;
	
	
	@Test 
	@DirtiesContext
	public void JPQLTest_Basic(){
	         List l = em.createQuery("select c from Course c").getResultList();
	         logger.info("Basic Query select c from Course c - {} ", l);
	}

	@Test 
	@DirtiesContext
	public void JPQLTest_TypedQuery(){
		     TypedQuery<Course> t = em.createQuery("select c from Course c", Course.class);
	         List<Course> l  = t.getResultList();
	         logger.info("Typed Query select c from Course c - {} ", l);
	}
	
	@Test 
	@DirtiesContext
	public void JPQLTest_WhereQuery(){
		     TypedQuery<Course> t = em.createQuery("select c from Course c where upper(name) like '%OPERATION%'", Course.class);
	         List<Course> l  = t.getResultList();
	         logger.info("Where clause query select c from Course c - {} ", l);
	}
}
