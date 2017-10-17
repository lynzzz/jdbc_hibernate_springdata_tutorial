package com.siemens.jdbc.jdbcDemo.jpa;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;


import org.springframework.stereotype.Repository;

import com.siemens.jdbc.jdbcDemo.entity.Person;

@Repository
@Transactional
public class JPARepository {
	


    
@PersistenceContext
EntityManager entityManager;




	public List<Person> getAll( ){
		TypedQuery<Person> ret = entityManager.createNamedQuery("find_all_persons", Person.class);
		return ret.getResultList();
	}
	

	public Person findByID(long id){
        return entityManager.find(Person.class, id);
	}
	
	public Person update(Person p){
        return entityManager.merge(p);
	}
	
	
	public void deleteByID(long id){
	      Person p = findByID(id);
	      entityManager.remove(p);
	}
}
