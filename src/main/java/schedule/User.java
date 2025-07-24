package schedule;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	int id;
	String name;
	String username;
	String email;
	String phone;
	String website;
}
