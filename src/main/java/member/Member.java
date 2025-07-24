package member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {
	int id;
	String name;
	String username;
	String password;
	String email;
}
