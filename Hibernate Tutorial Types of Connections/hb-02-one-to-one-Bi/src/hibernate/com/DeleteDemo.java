package hibernate.com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.com.entity.Instructor;
import hibernate.com.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			
			session.beginTransaction();
			
			session.get(Instructor.class, 3).setInstructorDetail(null);
			session.delete(session.get(InstructorDetail.class, 3));
			
			session.getTransaction().commit();
			
			
		}finally {
			factory.close();
		}

	}

}
