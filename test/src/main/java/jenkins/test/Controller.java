package jenkins.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class Controller {
    private final TestRepository tr;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> request) {
        // request에서 "username"과 "password" 값 추출
        String username = request.get("username");
        String password = request.get("password");
        log.info("성공");
        // 아이디와 비밀번호를 문자열로 반환
        String responseMessage = tr.makeEntity(username, password);

        // 페이지에 String 형태로 반환
        return ResponseEntity.ok(responseMessage);
    }
}
