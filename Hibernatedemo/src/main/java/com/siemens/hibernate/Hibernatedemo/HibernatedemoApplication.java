package com.siemens.hibernate.Hibernatedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.siemens.hibernate.Hibernatedemo.Entity.Course;
import com.siemens.hibernate.Hibernatedemo.Repository.CourseRepository;

@SpringBootApplication
public class HibernatedemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(HibernatedemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// Move to unit tests
		
		/*
		// Find 
		logger.info("find id 10001L -> {}", repo.findById(10001L));
		
		// Delete
		logger.info("delete ID 10001");
		repo.deleteById(10001L);
		*/
		
		// create
		//logger.info("creating new course -> {}", repo.save(new Course("Javascript")));
		
		
	    
		
	}
}
