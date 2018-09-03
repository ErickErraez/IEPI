package edu.iepi.hibernate.dao;

import java.util.List;

import edu.iepi.hibernate.model.Teacher;

public class TeacherDaoImpl extends YaviSession implements TeacherDao {

	private YaviSession yaviSession;

	public TeacherDaoImpl() {

		yaviSession = new YaviSession();

	}

	public void saveTeacher(Teacher teacher) {

		yaviSession.getSession().persist(teacher);
		yaviSession.getSession().getTransaction().commit();

	}

	public void deleteTeacherById(Long idTeacher) {

	}

	public void updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub

	}

	public List<Teacher> finAllTeachers() {

		return yaviSession.getSession().createQuery("from Teacher").list();

	}

	public Teacher findById(Long idTeacher) {
		// TODO Auto-generated method stub
		return null;
	}

	public Teacher findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
