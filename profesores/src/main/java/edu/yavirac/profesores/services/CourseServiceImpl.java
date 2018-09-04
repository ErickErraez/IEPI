package edu.yavirac.profesores.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.yavirac.profesores.dao.CourseDao;
import edu.yavirac.profesores.model.Courser;


@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired //llamar a un objeto mas generico y que sea compatible con este
	private CourseDao _courseDao; 	
	
	@Override
	public void saveCourse(Courser course) {
		// TODO Auto-generated method stub
		_courseDao.saveCourse(course);
	}

	@Override
	public void deleteCourseById(Long idCourse) {
		// TODO Auto-generated method stub
		_courseDao.deleteCourseById(idCourse);
	}

	@Override
	public void updateCourse(Courser course) {
		// TODO Auto-generated method stub
		_courseDao.updateCourse(course);
	}

	@Override
	public List<Courser> finAllCourses() {
		// TODO Auto-generated method stub
		return _courseDao.finAllCourses();
	}

	@Override
	public Courser findById(Long idCourse) {
		// TODO Auto-generated method stub
		return _courseDao.findById(idCourse);
	}

	@Override
	public Courser findByName(String name) {
		// TODO Auto-generated method stub
		return _courseDao.findByName(name);
	}

	@Override
	public List<Courser> findByIdTeacher(long idTeacher) {
		// TODO Auto-generated method stub
		return _courseDao.findByIdTeacher(idTeacher);
	}

}
