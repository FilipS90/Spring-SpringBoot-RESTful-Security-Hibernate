package payroll;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.context.annotation.Bean;

import lombok.Data;

@Data
@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private String role;
	
	Employee(String firstName, String lastName , String role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}
	
	Employee(){
		
	}
	
	public String getName() {
		return this.firstName + " " + this.lastName;
	}
	
	public void setName(String s) {
		this.firstName = s.split(" ")[0];
		this.lastName = s.split(" ")[1];
	}
	

}
