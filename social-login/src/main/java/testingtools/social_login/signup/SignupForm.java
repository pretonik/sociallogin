package testingtools.social_login.signup;

import java.util.UUID;

import javax.validation.constraints.Size;

import lombok.Data;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.social.connect.UserProfile;

@Data
public class SignupForm {

	@NotEmpty
	private String username;

	@Size(min = 6, message = "must be at least 6 characters")
	private String password;

	@NotEmpty
	private String firstName;

	@NotEmpty
	private String lastName;

	@NotEmpty
	private String email;

	public static SignupForm fromProviderUser(UserProfile providerUser) {
		SignupForm form = new SignupForm();
		form.setFirstName(providerUser.getFirstName());
		form.setLastName(providerUser.getLastName());
		form.setUsername(providerUser.getUsername());
		form.setPassword(UUID.randomUUID().toString());
		form.setEmail(providerUser.getEmail());
		form.setEmail("NO EMAIL");
		return form;
	}
}
