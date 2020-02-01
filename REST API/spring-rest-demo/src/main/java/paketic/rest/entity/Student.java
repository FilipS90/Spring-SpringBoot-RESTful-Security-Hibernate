package paketic.rest.entity;

public class Student {
	private String firstname;
	private String lastName;
	
	public Student(String firstname, String lastName) {
		this.firstname = firstname;
		this.lastName = lastName;
	}
	
	public Student() {
		
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
