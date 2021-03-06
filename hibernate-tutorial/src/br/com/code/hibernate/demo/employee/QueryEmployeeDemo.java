package br.com.code.hibernate.demo.employee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.code.hibernate.demo.entity.Employee;

public class QueryEmployeeDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Employee.class)
										.buildSessionFactory();
		
				
	   // create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			// start transaction 
			session.beginTransaction();
			
			// query Employees
			List<Employee> employees = session.createQuery("FROM Employee").getResultList();
	
			displayEmployees(employees);
			
			// query Employees: lastname='Doe'
			employees = session.createQuery("FROM Employee e WHERE e.lastName='Doe'").getResultList();
			
			// display the Employees
			System.out.println("\n\nEmployees who have last name of Doe");
			displayEmployees(employees);
						
			// query Employees: lastName='Doe' OR firstName='Daffy'
			employees = session.createQuery("FROM Employee e WHERE e.lastName='Doe' OR e.firstName='Daffy'").getResultList();
			
			System.out.println("\n\nEmployees who have last name of Doe OR first name Daffy");
			displayEmployees(employees);
			
			// query Employees where company Like '%'
			employees = session.createQuery("FROM Employee e WHERE e.company LIKE '%C'").getResultList();
			
			System.out.println("\n\nEmployees where company like '%C'");
			displayEmployees(employees);
			
			// commit transaction	
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			sessionFactory.close();
		}

	}

	private static void displayEmployees(List<Employee> Employees) {
		
		for (Employee Employee : Employees) {
			System.out.println(Employee);
		}
	}

}
