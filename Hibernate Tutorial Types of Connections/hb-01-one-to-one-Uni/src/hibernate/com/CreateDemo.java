package hibernate.com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.com.entity.Instructor;
import hibernate.com.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Instructor tempInstructor =
					new Instructor("Fica","Halt","FH@yahoo.com");
			
			InstructorDetail tempDetail =
					new InstructorDetail("Budzili", "weight lifting");
			
			tempInstructor.setId(4);;
			
			session.beginTransaction();
			
			session.delete(tempInstructor);
			
			session.getTransaction().commit();
			
			
		}finally {
			factory.close();
		}

	}

}
