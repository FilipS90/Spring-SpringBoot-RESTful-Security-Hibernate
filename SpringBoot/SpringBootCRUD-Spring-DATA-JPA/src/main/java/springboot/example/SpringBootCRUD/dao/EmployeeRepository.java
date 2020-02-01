package springboot.example.SpringBootCRUD.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.example.SpringBootCRUD.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
