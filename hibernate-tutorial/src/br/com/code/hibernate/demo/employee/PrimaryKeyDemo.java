package br.com.code.hibernate.demo.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.code.hibernate.demo.entity.Employee;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Employee.class)
										.buildSessionFactory();
		
				
	   // create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			// create object
			System.out.println("Creating new employee object...");
			Employee employee = new Employee("Jos�", "Augusto", "Camargo Correia");
			
			// start transaction 
			session.beginTransaction();
			
			// save object
			System.out.println("Saving the employee...");
			System.out.println(employee);
			session.save(employee);
			
			// commit transaction
			session.getTransaction().commit();
			
			// new code
			
			// find out the employee's id: primary key
			System.out.println("Saved employee. Generated id: " + employee.getId());
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\nGetting employee with id: " + employee.getId());
			
			Employee myEmployee = session.get(Employee.class, employee.getId());
			
			System.out.println("Get complete: " + myEmployee);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			sessionFactory.close();
		}
	}

}
