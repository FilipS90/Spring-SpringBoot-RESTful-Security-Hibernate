package springboot.example.SpringBootCRUD.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springboot.example.SpringBootCRUD.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private EntityManager manager;
	
	public EmployeeDAOImpl() {
		
	}
	
	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> query =
			manager.unwrap(Session.class)
			.createQuery("from Employee", Employee.class);
		
		List<Employee> result = query.getResultList();
		
		return result;
	}

	@Override
	public Employee findOne(int id) {
		Employee emp =
				manager.unwrap(Session.class).get(Employee.class,id);
		
		if(emp==null)
				throw new RuntimeException("No employee with id "+id);
		
		return emp;
	}
	
	@Override
	public void addEmployee(Employee e) {
		manager.unwrap(Session.class).persist(e);
	}

	@Override
	public Employee updateEmployee(int id, Employee e) {
		e.setId(id);
		
		manager.unwrap(Session.class).saveOrUpdate(e);
		return e;
		
	}
	
	@Override
	public boolean deleteEmployee(int id) {
		manager.unwrap(Session.class).delete(findOne(id));
		return true;
	}
	
}
