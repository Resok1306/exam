package login;

import lombok.Setter;
import lombok.ToString;
import lombok.Getter;

@Getter
@Setter
@ToString
public class LoginForm {
    private String username;
    private String password;
}