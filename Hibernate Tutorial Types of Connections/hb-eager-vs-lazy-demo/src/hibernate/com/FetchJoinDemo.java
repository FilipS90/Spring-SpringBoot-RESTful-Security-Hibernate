package hibernate.com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import hibernate.com.entity.Course;
import hibernate.com.entity.Instructor;
import hibernate.com.entity.InstructorDetail;

public class FetchJoinDemo {

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
			
			Query<Instructor> query =
					session.createQuery("select i from Instructor i "
							+ "JOIN FETCH i.courses "
							+ "where i.id=:x", Instructor.class);
			
			query.setParameter("x", id);
			
			Instructor ins = query.getSingleResult();
			
			session.getTransaction().commit();
			session.close();
			
			System.out.println("Session was closed.");
			
			System.out.println("\n"+ins.getCourses());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			factory.close();
		}

	}

}
