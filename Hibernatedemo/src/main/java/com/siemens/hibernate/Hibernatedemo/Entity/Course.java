package com.siemens.hibernate.Hibernatedemo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {
    @Id
    @GeneratedValue
	private long id;
    private String name;
    
    public Course(String name){
    	this.name = name;
    }
    
    protected Course(){
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
}
