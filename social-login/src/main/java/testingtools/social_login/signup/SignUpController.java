package testingtools.social_login.signup;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import testingtools.social_login.account.Account;
import testingtools.social_login.account.AccountsRepository;
import testingtools.social_login.account.UsernameAlreadyInUseException;
import testingtools.social_login.messages.Message;
import testingtools.social_login.messages.MessageType;
import testingtools.social_login.signin.SignInUtils;

@Controller
public class SignUpController {
	
	private final AccountsRepository accountRepository;
	private final ProviderSignInUtils providerSignInUtils;
	
	@Inject
	public SignUpController(AccountsRepository accountRepository) {
		this.accountRepository = accountRepository;
		this.providerSignInUtils = new ProviderSignInUtils();
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public SignupForm showRegistrationForm(WebRequest request, Model model) {
		
		Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);
		if (connection != null) {
			request.setAttribute("message", new Message(MessageType.INFO, "Your " + StringUtils.capitalize(connection.getKey().getProviderId()) + " account is not associated with a Spring Social Showcase account. If you're new, please sign up."), WebRequest.SCOPE_REQUEST);
//			return SignupForm.fromProviderUser(connection.fetchUserProfile());
			SignupForm signupForm = SignupForm.fromProviderUser(connection.fetchUserProfile());
			signUp(signupForm, request);
			return signupForm;
		} else {
//			return "signup";
			return new SignupForm();
		}
		
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@Valid SignupForm form, BindingResult formBinding, WebRequest request) {
		if (formBinding.hasErrors()) {
			return null;
		}
		Account account = createAccount(form/*, formBinding)*/);
		if (account != null) {
			SignInUtils.signin(account.getUsername());
			providerSignInUtils.doPostSignUp(account.getUsername(), request);
			return "redirect:/";
		}
		return null;
	}
	
	private boolean signUp(SignupForm form, WebRequest request){
		Account account = createAccount(form);
		if (account != null) {
			SignInUtils.signin(account.getUsername());
			providerSignInUtils.doPostSignUp(account.getUsername(), request);
			return true;
		}
		return false;
	}

	// internal helpers
	
	private Account createAccount(SignupForm form) {
		try {
			Account account = new Account(form.getUsername(), form.getPassword(), form.getFirstName(), form.getLastName(), form.getEmail());
			accountRepository.create(account);
			return account;
		} catch (UsernameAlreadyInUseException e) {
			//formBinding.rejectValue("username", "user.duplicateUsername", "already in use");
			return null;
		}
	}
}
