package schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
	@Autowired
	ScheduleMapper dao;
	
	public void updateUsers(List<User> users) {
		 for (User external : users) {
			 User existing = dao.findById(external.getId());
	            if (existing == null) {
	            	dao.save(external);
	                System.out.println("INSERT: " + external.getName());
	            } else {
	                if (!isSame(existing, external)) {
	                    existing.setName(external.getName());
	                    existing.setUsername(external.getUsername());
	                    existing.setEmail(external.getEmail());

	                    dao.save(existing);
	                    System.out.println("UPDATE: " + external.getName());
	                } else {
	                    System.out.println("NO CHANGE: " + external.getName());
	                }
	           }
		 }
	}
	
	private boolean isSame(User m1, User m2) {
        return m1.getName().equals(m2.getName()) &&
               m1.getUsername().equals(m2.getUsername()) &&
               m1.getEmail().equals(m2.getEmail());
    }
}
