package testingtools.social_login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.connect.web.SignInAdapter;

import testingtools.social_login.signin.MySignInAdapter;

@Configuration
@EnableSocial
public class SocialConfig {
	
    @Bean
	public SignInAdapter signInAdapter() {
		return new MySignInAdapter(new HttpSessionRequestCache());
	}
}
