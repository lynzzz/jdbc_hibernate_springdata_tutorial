package com.siemens.jdbc.jdbcDemo;


import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JdbcDemoApplication implements CommandLineRunner{
   
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    PersonDAO personDAO;

                 

	public static void main(String[] args) {
		SpringApplication.run(JdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        logger.info("All users -> {}", personDAO.getAll() );
		logger.info("user 10001 -> {}", personDAO.findByID(10001) );
		logger.info("user Raj deleted, number of row deleted -> {}", personDAO.deleteByName("Raj"));
		logger.info("user 10004 inserted -> {}", personDAO.insert(new Person(10004L, "Rachel", "17652 christ name", new Date(1574))));
		logger.info("user 10003 updated -> {}", personDAO.update(new Person(10003L, "Catherine", "St. Louis", new Date(1574))));

	}
}
 