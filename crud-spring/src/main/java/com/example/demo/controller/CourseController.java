package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

	private CourseRepository courseRepository;

	@GetMapping
	public List<Course> listCourses() {
		return courseRepository.findAll();
	}

	@GetMapping("/{idCourse}")
	public ResponseEntity<Course> getCourseById(@PathVariable("idCourse") Long idCourse) {
		return courseRepository.findById(idCourse).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping	
	@ResponseStatus(code = HttpStatus.CREATED)
	public Course createCourse(@RequestBody Course course) {
		return courseRepository.save(course);
	}
	
}
