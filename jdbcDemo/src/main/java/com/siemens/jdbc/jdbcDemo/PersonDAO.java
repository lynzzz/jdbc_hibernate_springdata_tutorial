package com.siemens.jdbc.jdbcDemo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAO {
	

    class PersonRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet arg0, int arg1) throws SQLException {
            Person p = new Person();
            p.setId(arg0.getLong("id"));
            p.setName(arg0.getString("name"));
            p.setLocation(arg0.getString("location"));
            p.setBirth_date(arg0.getDate("birth_date"));
    	    return p;
        }   
    }
    
@Autowired
JdbcTemplate jdbc;




	public List<Person> getAll(){
		String sql = "select * from person";
		return jdbc.query(sql, new PersonRowMapper() );
		
	}
	
	public Person findByID(long id){
		return this.jdbc.queryForObject("select * from person where id = ?",
				               new Object[] {id},
				               new RowMapper<Person>(){
								public Person mapRow(ResultSet arg0, int arg1) throws SQLException {
									Person p = new Person();
									p.setId(arg0.getLong("id"));
									p.setName(arg0.getString("name"));
									p.setLocation(arg0.getString("location"));
									p.setBirth_date(arg0.getDate("birth_date"));
									return p;
								}
		});
	}
	
	public int deleteByID(long id){
		return this.jdbc.update("delete from person where id = ?",
				               new Object[] {id}
				               );
	}
	
	public int deleteByName(String name){
		return this.jdbc.update("delete from person where name = ?",
				               new Object[] {name}
				               );
	}
	
	public int insert(Person p){
		return this.jdbc.update("insert into person (id, name, location, birth_date) values(?,?,?,?)",
				                new Object[] {p.getId(), p.getName(), p.getLocation(), p.getBirth_date()
				                		}
				                );
	}
	
	public int update(Person p){
		return this.jdbc.update("update person set name = ?, location=?, birth_date=? where id = ?",
				                new Object[]{p.getName(), p.getLocation(), p.getBirth_date(), p.getId()});
	}
}
