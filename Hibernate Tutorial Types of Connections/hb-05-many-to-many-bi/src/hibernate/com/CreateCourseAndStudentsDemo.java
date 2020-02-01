package hibernate.com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.com.entity.Course;
import hibernate.com.entity.Instructor;
import hibernate.com.entity.InstructorDetail;
import hibernate.com.entity.Review;
import hibernate.com.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Course course = new Course("PacmanPro");
			
			session.save(course);
			
			Student s = new Student("John", "Doe","myemail@voice.com");
			Student s2 = new Student("Fica", "Stojiljkovic","fica@voice.com");
			
			course.addStudent(s);
			course.addStudent(s2);
			
			session.save(s);
			session.save(s2);
			
			session.getTransaction().commit();
			
			
		}finally {
			factory.close();
		}

	}

}
