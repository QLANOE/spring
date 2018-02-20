package poe.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poe.spring.model.User;
import poe.spring.repository.UserRepository;

@Service
public class UserServices {

	@Autowired
	UserRepository userRepository;

	public User inscription(String login, String password) {

		User user = new User();
		user.setLogin(login);
		user.setPassword(password);
		userRepository.save(user);
		return user;
	}

	public List<User> listerUsers() {

		List<User> users = (List<User>) userRepository.findAll();
		return users;
	}

	public User chercherUser(Long id) {

		User user = userRepository.findOne(id);
		return user;
	}

	public User chercherUserParLogin(String login) {

		User user = userRepository.findByLogin(login);
		return user;
	}

	public void supprimerUser(Long id) {

		userRepository.delete(id);

	}

	public User modifierUser(String login, String password, Long id) {

		User user = chercherUser(id);
		user.setLogin(login);
		user.setPassword(password);
		userRepository.save(user);
		return user;
	}

}
