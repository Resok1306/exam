package schedule;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component("ScheduledWork")
public class ScheduleWork {
	@Autowired
	ScheduleService service;
	
	private String lastJsonData = "";
	
	@Scheduled(cron="0/10 * * * * ?")
	public void work2() throws MalformedURLException, IOException {
		String address="http://localhost:8888/api/users";
		URL url=new URL(address);
		InputStream in=url.openStream();
		
		StringBuilder sb = new StringBuilder();
        int read;
        while ((read = in.read()) != -1) {
            sb.append((char) read);
        }
        String jsonData = sb.toString();

        if (Objects.equals(jsonData, lastJsonData)) {
            System.out.println("변경 없음 → 업데이트 스킵");
            return;
        }

        lastJsonData = jsonData;

        ObjectMapper mapper = new ObjectMapper();
        User[] users = mapper.readValue(jsonData, User[].class);

        if (users.length > 0) {
            System.out.println("변경 감지됨 → 업데이트 수행");
            System.out.println("첫 사용자 이름: " + users[0].getName());

            service.updateUsers(Arrays.asList(users));
		}
	}
}
