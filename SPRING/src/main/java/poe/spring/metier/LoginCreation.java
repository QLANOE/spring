package poe.spring.metier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class LoginCreation {

	static List<String> loginsInterdit = new ArrayList<>(Arrays.asList("toto", "tata", "titi", "Guillaume, Nicolas"));

	public static boolean checkTailleLogin(String login) {

		if (login.length() > 3 && login.length() < 11) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkLoginInterdit(String login) {

		for (String login1 : loginsInterdit) {
			if (login1.equalsIgnoreCase(login)) {
				return false;
			}
		}
		return true;
	}

	public static boolean testsLogin(String login) {
		boolean checkTailleLogin = checkTailleLogin(login);
		boolean checkLoginInterdit = checkLoginInterdit(login);
		return (checkLoginInterdit && checkTailleLogin);
	}

}
