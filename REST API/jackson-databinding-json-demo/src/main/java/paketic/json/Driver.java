package paketic.json;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			
			Student s = mapper.readValue(
					new File("data/sample-full.json"), Student.class);
			
			System.out.println(s.getFirstName()+" with id "+s.getId()+" and last name "+s.getLastName());
			
			Address a = s.getAddress();
			System.out.println(a.getCity());
			
			for(String x : s.getLanguages())
				System.out.print(x+" ");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
