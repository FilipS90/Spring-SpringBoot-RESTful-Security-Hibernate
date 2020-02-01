package hibernate.com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.com.entity.Course;
import hibernate.com.entity.Instructor;
import hibernate.com.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int id = 1;
			Instructor ins = session.get(Instructor.class, id);
			
			System.out.println("Instructor: "+ins);
			
			session.getTransaction().commit();
			
			System.out.println("Courses:"+ins.getCourses());
			
			
		}finally {
			factory.close();
		}

	}

}
