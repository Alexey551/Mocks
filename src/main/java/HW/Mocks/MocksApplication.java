package HW.Mocks;

import HW.Mocks.Profile.User;
import HW.Mocks.workingClass.DataBaseWorking;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MocksApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(MocksApplication.class, args);
		DataBaseWorking dataBaseWorking = new DataBaseWorking();
		User user = dataBaseWorking.select_user("user_1");
		System.out.println(user);

		String insert = dataBaseWorking.insert_user(new User("user_7", "77777", "2023-09-08", "user_7@mail.ru"));
		System.out.println(insert);

	}
}
