package edu.yavirac.profesores.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import edu.yavirac.profesores.model.Courser;
import edu.yavirac.profesores.model.SocialMedia;
import edu.yavirac.profesores.model.Teacher;


@Repository
@Transactional
public class CourseDaoImpl extends AbstaractSession implements CourseDao {

	@Override
	public void saveCourse(Courser course) {
		getSession().persist(course);
	}

	@Override
	public void deleteCourseById(Long idCourse) {

		Courser course = findById(idCourse);
		if (course != null) {
			getSession().delete(course);
		}

	}

	@Override
	public void updateCourse(Courser course) {
		getSession().update(course);
	}

	@Override
	public List<Courser> finAllCourses() {

		return getSession().createQuery("from Courser").list();
	}

	@Override
	public Courser findById(Long idCourse) {

		return (Courser) getSession().get(Courser.class, idCourse);
	}

	@Override
	public Courser findByName(String name) {
		// TODO Auto-generated method stub
		return (Courser) getSession().createQuery("from Courser where name = :name").setParameter("name", name)
				.uniqueResult();
	}

	@Override
	public List<Courser> findByIdTeacher(long idTeacher) {
		// TODO Auto-generated method stub
		return (List<Courser>) getSession()
				.createQuery("from Courser c join c.teacher t where t.idTeacher = :idTeacher")
				.setParameter("idTeacher", idTeacher).list();
	}

}
