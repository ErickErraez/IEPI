package edu.iepi.hibernate;

import java.util.List;

import javax.security.auth.login.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.iepi.hibernate.dao.TeacherDaoImpl;
import edu.iepi.hibernate.model.Courser;
import edu.iepi.hibernate.model.Teacher;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		System.out.println("Hello World!");

		Teacher teacher = new Teacher("Christian", "Avatar");
		TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
		teacherDaoImpl.saveTeacher(teacher);
		List<Teacher> teachers = teacherDaoImpl.finAllTeachers();

		for (Teacher t : teachers) {
			System.out.println("Nombre: " + t.getName());
		}

	}
}
