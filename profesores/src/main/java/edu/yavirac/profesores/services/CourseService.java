package edu.yavirac.profesores.services;

import java.util.List;

import edu.yavirac.profesores.model.Courser;

public interface CourseService {
	void saveCourse(Courser course);

	void deleteCourseById(Long idCourse);

	void updateCourse(Courser course);

	List<Courser> finAllCourses();

	Courser findById(Long idCourse);

	Courser findByName(String name);

	List<Courser> findByIdTeacher(long idTeacher);

}
