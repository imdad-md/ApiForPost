package com.jpacheck;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WithoutwebjpaApplication {

//	@Autowired
//	private StudentRepository studentRepository; 
	public static void main(String[] args) {
 SpringApplication.run(WithoutwebjpaApplication.class, args);
//		StudentRepository studentRepository = context.getBean(StudentRepository.class);

//		Student student1 = new Student();
//
//		student1.setAddress("del");
//		student1.setCity("azad road");
//		student1.setName("imran khan");
//
//		Student student2 = new Student();
//
//		student2.setAddress("raja bazzar");
//		student2.setCity("patna");
//		student2.setName("ravi");
//
//		List<Student> list = new ArrayList<>();
//		list.add(student1);
//		list.add(student2);
//		
////saving the data
//		Iterable<Student> savedall = studentRepository.saveAll(list);
//		for (Student check : savedall) {
//
//			System.out.println(check);
//		}
////fetching the data by id
//		Optional<Student> found = studentRepository.findById(57);
//		System.out.println(found);
//
//		// fetching all the data
//		Iterable<Student> allStudent = studentRepository.findAll();
//		for (Student founds : allStudent) {
//
//			System.out.println(founds);
//
//		}
//
//// updating the data
//		Optional<Student> findById = studentRepository.findById(57);
//
//		Student student3 = findById.get();
//
//		student3.setAddress("khanpur");
//		student3.setCity("lucknow");
//
//		Student student4 = studentRepository.save(student3);
//		System.out.println(student4);
//
//// deleting the data by id
//		studentRepository.deleteById(57);
//		System.out.println("deleted");
//
//// deleting all the data
//		studentRepository.deleteAll();
//		System.out.println("all deleted");
	}
}
