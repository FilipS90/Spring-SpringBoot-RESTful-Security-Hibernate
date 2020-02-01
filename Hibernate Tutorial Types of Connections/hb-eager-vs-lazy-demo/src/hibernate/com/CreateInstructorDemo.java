package hibernate.com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.com.entity.Course;
import hibernate.com.entity.Instructor;
import hibernate.com.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Instructor tempInstructor =
					new Instructor("Joe","Olum","XO@yahoo.com");
			
			InstructorDetail tempDetail =
					new InstructorDetail("youtube.com", "bouncing");
			
			tempInstructor.setInstructorDetail(tempDetail);
			
			session.beginTransaction();
			
			session.save(tempInstructor);
			
			session.getTransaction().commit();
			
			
		}finally {
			factory.close();
		}

	}

}
