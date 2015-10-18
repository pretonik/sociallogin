package testingtools.social_login.account;

public interface AccountsRepository {

	void create(Account account) throws UsernameAlreadyInUseException;

	Account findAccountBy(String username);
}
