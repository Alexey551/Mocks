package HW.Mocks.Controller;
import HW.Mocks.Exception.ResponseException;
import HW.Mocks.Profile.User;
import HW.Mocks.workingClass.DataBaseWorking;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;


@RestController
public class MessageController {
    @GetMapping("/selectUser/{login}")
    public ResponseEntity<User> getUser(@PathVariable String login) throws Exception {
        User user;
        try {
            DataBaseWorking dataBaseWorking = new DataBaseWorking();
            user = dataBaseWorking.select_user(login);

            if (user == null) {
                throw new ResponseException("DB problems");
            }
            return ResponseEntity.ok(user);
        } catch (SQLException | ResponseException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping("/insertUser")
    public ResponseEntity<String> postUser(@RequestBody User user) throws Exception {
        try {
            DataBaseWorking dataBaseWorking = new DataBaseWorking();
            String result = dataBaseWorking.insert_user(user);

            return ResponseEntity.ok(result);
        } catch (ResponseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}

