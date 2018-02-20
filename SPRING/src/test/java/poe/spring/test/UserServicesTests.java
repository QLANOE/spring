package poe.spring.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import poe.spring.model.User;
import poe.spring.repository.UserRepository;
import poe.spring.services.UserServices;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServicesTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserServices userServices;

	@Test
	public void creationUser() {

		assertThat(userRepository.count() == 0);

		String login = "bob";
		String password = "pwd";

		User userCreated = userServices.inscription(login, password);
		assertThat(userCreated).isNotNull();
		assertThat(userCreated.getLogin().equals(login));

		User userSaved = userRepository.findOne(userCreated.getId());
		assertThat(userSaved).isNotNull();
		assertThat(userSaved.getLogin().equals(login));

	}

	@Test
	public void destructionUser() {

		assertThat(userRepository.count() == 0);

		String login = "bob";
		String password = "pwd";

		User userCreated = userServices.inscription(login, password);
		assertThat(userRepository.count() > 0);
		assertThat(userCreated).isNotNull();
		assertThat(userCreated.getLogin().equals(login));

		userRepository.delete(userCreated.getId());

		User userSaved = userRepository.findOne(userCreated.getId());
		assertThat(userSaved).isNull();

	}

}