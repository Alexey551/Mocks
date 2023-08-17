package HW.Mocks.Controller;
import HW.Mocks.Exception.ResponseException;
import HW.Mocks.Profile.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
public class MessageController {
    @GetMapping("/login")
    public ResponseEntity<User> getQuery() {
        return ResponseEntity.ok(new User("11111", "qqqqqq"));
    }

    @PostMapping("/login")
    public ResponseEntity<User> postQuery(@RequestBody User user) throws ResponseException {
        String date = LocalDate.now().toString();
        if (user.getPassword() != "" && user.getLogin() != "") {
            return ResponseEntity.ok(new User(user.getLogin(), user.getPassword(), date));
        }
        throw new ResponseException();
    }
}

