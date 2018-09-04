package edu.yavirac.profesores.dao;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import edu.yavirac.profesores.model.Teacher;
import edu.yavirac.profesores.model.TeacherSocialMedia;

@Repository
@Transactional
public class TeacherDaoImpl extends AbstaractSession implements TeacherDao {

	public void saveTeacher(Teacher teacher) {
		getSession().persist(teacher);
	}

	public void deleteTeacherById(Long idTeacher) {
		
		Teacher teacher = findById(idTeacher);
		if (teacher != null) {

			Iterator<TeacherSocialMedia> i = teacher.getTeacherSocialMedias().iterator();
			while (i.hasNext()) {
				TeacherSocialMedia teacherSocialMedia = i.next();
				i.remove();
				getSession().delete(teacherSocialMedia);
			}
			teacher.getTeacherSocialMedias().clear();
			getSession().delete(teacher);
		}
	}

	public void updateTeacher(Teacher teacher) {

		getSession().update(teacher);
	}

	public List<Teacher> finAllTeachers() {

		return getSession().createQuery("from Teacher").list();

	}

	public Teacher findById(Long idTeacher) {
		// TODO Auto-generated method stub
		return (Teacher) getSession().get(Teacher.class, idTeacher);
	}

	public Teacher findByName(String name) {
		// TODO Auto-generated method stub
		return (Teacher) getSession().createQuery("from Teacher where name = :name").setParameter("name", name)
				.uniqueResult();
	}

}
