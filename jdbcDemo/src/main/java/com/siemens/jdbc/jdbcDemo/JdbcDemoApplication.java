package com.siemens.jdbc.jdbcDemo;


import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.siemens.jdbc.jdbcDemo.entity.Person;
import com.siemens.jdbc.jdbcDemo.jpa.JPARepository;


@SpringBootApplication
public class JdbcDemoApplication implements CommandLineRunner{
   
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    JPARepository repository;

                 

	public static void main(String[] args) {
		SpringApplication.run(JdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("user 10001 -> {}", repository.findByID(10001) );
		logger.info("user inserted -> {}", repository.update(new Person("Rachel", "17652 christ name", new Date(1574))));
		logger.info("user 10003 updated -> {}", repository.update(new Person(10003L, "Catherine", "St. Louis", new Date(1574))));
		 repository.deleteByID(10002);
	    logger.info("All users -> {}", repository.getAll() );



	}
}
 