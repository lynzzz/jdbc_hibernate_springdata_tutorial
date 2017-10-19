package com.siemens.hibernate.Hibernatedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		logger.info("find id 10001L -> {}", repo.findById(10001L));
	}
}
