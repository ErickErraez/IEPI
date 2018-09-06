package edu.yavirac.profesores.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.yavirac.profesores.model.Courser;
import edu.yavirac.profesores.model.SocialMedia;
import edu.yavirac.profesores.services.CourseService;
import edu.yavirac.profesores.until.CustomErrorType;

@Controller
@RequestMapping("/v1")
public class CourseController {

	@Autowired
	CourseService _courseService;

	// GET ALL OR NAME
	@RequestMapping(value = "/course", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Courser>> getCourses(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "id_teacher", required = false) Long id_teacher) {
		List<Courser> courses = new ArrayList<Courser>();
		if (id_teacher != null) {
			courses = _courseService.findByIdTeacher(id_teacher);
			if (courses.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

		}

		if (name != null) {
			Courser course = _courseService.findByName(name);
			if (course == null) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
				// You many decide to return HttpStatus.NOT_FOUND
			}
			courses.add(course);

		}

		if (name == null && id_teacher == null) {
			courses = _courseService.finAllCourses();
			if (courses.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
				// You many decide to return HttpStatus.NOT_FOUND
			}

		}

		return new ResponseEntity<List<Courser>>(courses, HttpStatus.OK);

	}

	// GET BY ID
	@RequestMapping(value = "/course/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Courser> getCourseById(@PathVariable("id") Long idCourse) {

		if (idCourse == null || idCourse <= 0) {
			return new ResponseEntity(new CustomErrorType("idCourse is required"), HttpStatus.CONFLICT);
		}

		Courser courser = _courseService.findById(idCourse);
		if (courser == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);

		}

		return new ResponseEntity<Courser>(courser, HttpStatus.OK);
	}

	// POST
	@RequestMapping(value = "/course", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createCourse(@RequestBody Courser course, UriComponentsBuilder ucBuilder) {
		if (_courseService.findByName(course.getName()) != null) {
			// logger.error("Unable to create. A User with name {} already
			// exist", user.getName());
			return new ResponseEntity(
					new CustomErrorType("Unable to create. A course with name " + course.getName() + " already exist."),
					HttpStatus.CONFLICT);
		}
		_courseService.saveCourse(course);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/v1/courses/{id}").buildAndExpand(course.getIdCourse()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// UPDATE
	@RequestMapping(value = "/course/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<?> updateCourses(@PathVariable("id") Long id, @RequestBody Courser course) {

		Courser currentCourse = _courseService.findById(id);

		if (currentCourse == null) {
			return new ResponseEntity(
					new CustomErrorType("Unable to upate. Social Media with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentCourse.setName(course.getName());
		currentCourse.setThemes(course.getThemes());
		currentCourse.setProject(course.getProject());

		_courseService.updateCourse(currentCourse);
		return new ResponseEntity<Courser>(currentCourse, HttpStatus.OK);
	}

	// DELETE
	@RequestMapping(value = "/course/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteCourse(@PathVariable("id") Long id) {
		System.out.println("course ID recived: " + id);

		Courser course = _courseService.findById(id);
		if (course == null) {
			System.out.println("Unable to delete. course with id not found. " + id);

			return new ResponseEntity(new CustomErrorType("Unable to delete. course with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		_courseService.deleteCourseById(id);
		return new ResponseEntity<Courser>(HttpStatus.NO_CONTENT);
	}
}
