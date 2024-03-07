package com.myprojects.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.myprojects.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.myprojects.springboot.learnjpaandhibernate.course.jdbc.CourseJpaRepository;
import com.myprojects.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{

	//@Autowired
	//private CourseJdbcRepository repository;
	//@Autowired
	//private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1,"AWS","Sai"));
		repository.save(new Course(2,"Java","Mohan"));
		repository.save(new Course(3,"Python","Bharath"));
		repository.save(new Course(4,"Big Data","Pandu"));
		
		repository.deleteById(1l);
		System.out.println(repository.findById(2l));
		System.out.println(repository.findByName("Big Data"));
		System.out.println(repository.findByAuthor("Bharath"));
	}
}
