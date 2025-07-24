package page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController //restController는 데이터만 전송하는 컨트롤러
@Controller
public class PageController {
	
	@GetMapping("/main")
	public String userIndex() {
		return "main";
	}
}
