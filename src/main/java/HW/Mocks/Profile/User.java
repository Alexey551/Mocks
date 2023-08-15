package HW.Mocks.Profile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private String login;
    private String password;
    private String date;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" + "login'" + login + '\'' + ", password='" + password + '\'' + ", date='" + date + '\'' + '}';
    }

}
