package testingtools.social_login.account;

public class UsernameAlreadyInUseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2878612545527256793L;

	public UsernameAlreadyInUseException(String username) {
		super("The username '" + username + "' is already in use.");
	}
}
