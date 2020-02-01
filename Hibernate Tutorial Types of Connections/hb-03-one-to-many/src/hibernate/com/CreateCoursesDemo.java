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
			
			Instructor tempInstructor =
					new Instructor("Joe","Olum","XO@yahoo.com");
			
			InstructorDetail tempDetail =
					new InstructorDetail("youtube.com", "bouncing");
			
			Course c = new Course();
			
			session.get(Instructor.class, 2).setInstructorDetail(tempDetail);
			
			session.getTransaction().commit();
			
			
		}finally {
			session.close();
			factory.close();
		}

	}

}
