package com.siemens.hibernate.Hibernatedemo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.siemens.hibernate.Hibernatedemo.Entity.Course;
import com.siemens.hibernate.Hibernatedemo.Repository.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=HibernatedemoApplication.class)
public class HibernatedemoApplicationTests {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
    @Autowired
    CourseRepository repo;
	
	
	@Test
	public void findByID_test_10001L() {
		Course c = repo.findById(10001L);
		assertEquals("Introducton to algorithm", c.getName());
		logger.info("I am running test");
	}

}
