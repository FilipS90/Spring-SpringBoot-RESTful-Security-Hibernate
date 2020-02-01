package hibernate.com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.com.entity.Course;
import hibernate.com.entity.Instructor;
import hibernate.com.entity.InstructorDetail;
import hibernate.com.entity.Review;
import hibernate.com.entity.Student;

public class CreateCourseandReviewsDemo {

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
			
			course.addReview(new Review("Great!!"));
			course.addReview(new Review("Waste of money!"));
			
			session.save(course);
			System.out.println("Kurs je sacuvan, a u njemu su kursevi: "+course.getReviews());
			session.getTransaction().commit();
			
			
		}finally {
			factory.close();
		}

	}

}
