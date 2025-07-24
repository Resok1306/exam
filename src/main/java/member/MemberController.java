package member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MemberController {

	@Autowired
	MemberService service;
	
	@GetMapping("register")
	public String getRegister() {
		return "fragments/register";
	}
	
	@PostMapping("register")
	public String register(RegisterForm form) {
		System.out.println(form);
		service.save(form);
		return "main";
	}
}
