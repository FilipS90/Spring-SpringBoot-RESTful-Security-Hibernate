package paketic.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import paketic.rest.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> students;
	
	// define @PostConstruct to load the student data, only once!
	
	@PostConstruct
	public void loadData() {
		
		students = new ArrayList<Student>();
		
		students.add(new Student("Filip", "Stojiljkovic"));
		students.add(new Student("Marko","Milovanovic"));
		students.add(new Student("Poornima", "Patel"));
	}
	
	@GetMapping(path="/students")
	public List<Student> getStudents(){
		
		return students;

	}
	
	@GetMapping(path="/students/{studentId}")
	public Student getStudentsId(@PathVariable int studentId){
		
		return students.get(studentId);

	}
}
