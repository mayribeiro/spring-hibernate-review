package br.com.code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
				
	   // create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			// start transaction 
			session.beginTransaction();
			
			// query students
			List<Student> students = session.createQuery("FROM Student").getResultList();
	
			displayStudent(students);
			
			// query students: lastname='Doe'
			students = session.createQuery("FROM Student s WHERE s.lastName='Doe'").getResultList();
			
			// display the students
			System.out.println("\n\nStudents who have last name of Doe");
			displayStudent(students);
						
			// query students: lastName='Doe' OR firstName='Daffy'
			students = session.createQuery("FROM Student s WHERE s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
			
			System.out.println("\n\nStudents who have last name of Doe OR first name Daffy");
			displayStudent(students);
			
			// query students where email Like '%hotmail.com'
			students = session.createQuery("FROM Student s WHERE s.email LIKE '%hotmail.com'").getResultList();
			
			System.out.println("\n\nStudents where email like '%hotmail.com'");
			displayStudent(students);
			
			// commit transaction	
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			sessionFactory.close();
		}

	}

	private static void displayStudent(List<Student> students) {
		
		for (Student student : students) {
			System.out.println(student);
		}
	}

}
