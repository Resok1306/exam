package schedule;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class UserProxyController {

    @GetMapping("/users")
    public ResponseEntity<String> getUsers() {
        String externalApi = "https://jsonplaceholder.typicode.com/users";
        try {
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(externalApi, String.class);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("오류 발생");
        }
    }
}