package schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScheduleController {
	@Autowired
	ScheduleMapper dao;
	
	@GetMapping("/schedule")
    public String listUsers() {
        return "fragments/schedule";
    }
}
