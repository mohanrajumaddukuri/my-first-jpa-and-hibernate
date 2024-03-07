package com.myprojects.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myprojects.springboot.learnjpaandhibernate.course.Course;

@Repository
public class CourseJdbcRepository {
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String SELECT_QUERY=
			"""
			 	select * from course
			 	where id=?
			""";
	
	public void insert(Course course) {
		//springJdbcTemplate.update("insert into course(id,name,author)values(1,'AWS','Sai')");
		//springJdbcTemplate.update("insert into course(id,name,author)values(2,'Java','Mohan')");
		springJdbcTemplate.update("insert into course(id,name,author)values(?,?,?)", course.getId(),course.getName(),course.getAuthor());
	}
	
	public void deleteById(long id) {
		springJdbcTemplate.update("delete from course where id=?",id);
	}
	
//	public Course findById() {
//		
//	}
}
