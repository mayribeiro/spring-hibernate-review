package br.com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
				
	   // create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			session.beginTransaction();
			
			System.out.println("\nGetting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student...");
			myStudent.setFirstName("Scooby");
			
			session.getTransaction().commit();
			
			// New Code
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for all students
			System.out.println("Update email for all students");
			
			session.createQuery("UPDATE Student SET email='foo@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
