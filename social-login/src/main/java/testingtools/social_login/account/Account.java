package testingtools.social_login.account;

import lombok.Data;

@Data
public class Account {

	private final String username;

	private final String password;

	private final String firstName;

	private final String lastName;

	private final String email;
}
