package com.siemens.hibernate.Hibernatedemo.Entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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

@RunWith(SpringRunner.class)
@SpringBootTest(classes=HibernatedemoApplication.class)
public class CourseRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
    @Autowired
    CourseRepository repo;
	
	
	@Test
	public void findByID_test_10001L() {
		Course c = repo.findById(10001L);
		assertEquals("Introducton to algorithm", c.getName());
		logger.info("I am running test");
	}
	
	@Test 
	@DirtiesContext
	public void deleteById_test(){
		repo.deleteById(10002L);
		assertNull(repo.findById(10002L));
	}

	@Test 
	@DirtiesContext
	public void save_persist_test(){
		
		Course c = repo.save(new Course("Javascript"));
		
		assertEquals("Javascript", repo.findById(c.getId()).getName());
	}
	
	@Test 
	@DirtiesContext
	public void save_merge_test(){
		
		// read from db
        Course c = repo.findById(10001L);
        
		assertEquals("Introducton to algorithm",c.getName());
		
		// make change
		c.setName("Python");
		
		// write to db
		repo.save(c);
		
		
		// read from db again
		Course c1 = repo.findById(10001L);
		assertEquals("Python", c1.getName());
	}
}
