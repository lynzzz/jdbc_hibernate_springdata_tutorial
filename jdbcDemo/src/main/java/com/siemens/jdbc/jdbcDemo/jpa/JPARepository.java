package com.siemens.jdbc.jdbcDemo.jpa;


import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.siemens.jdbc.jdbcDemo.entity.Person;

public interface JPARepository extends CrudRepository<Person, Long> {
	        List<Person> findByName(String name);
   
}
