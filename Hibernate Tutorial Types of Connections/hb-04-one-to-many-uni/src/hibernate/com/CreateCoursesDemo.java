package hibernate.com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.com.entity.Course;
import hibernate.com.entity.Instructor;
import hibernate.com.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
			Course c1 = new Course("Air guitar");
			Course c2 = new Course("Pinball Masterclass");
			
			ins.add(c1);
			ins.add(c2);
			
			session.save(c1);
			session.save(c2);
			
			session.getTransaction().commit();
			
			
		}finally {
			factory.close();
		}

	}

}
