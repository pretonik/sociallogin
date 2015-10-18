package testingtools.social_login.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.connect.web.SignInAdapter;

import testingtools.social_login.signin.MySignInAdapter;

@Configuration
@EnableSocial
public class SocialConfig {


//	@Inject
//	private ConnectionFactoryLocator connectionFactoryLocator;
//	
//	@Inject
//	private UsersConnectionRepository usersConnectionRepository;


//	@Bean
//    public ProviderSignInController providerSignInController() {
//        ProviderSignInController controller = new ProviderSignInController(connectionFactoryLocator, 
//                usersConnectionRepository, signInAdapter());

//        controller.setSignUpUrl("/register");
//        controller.setSignInUrl("/socialSignIn");
//        controller.setPostSignInUrl("socialSignIn");
//        controller.addSignInInterceptor(new RedirectAfterConnectInterceptor());



//        return controller;
//    }
    
//	@Bean
//    public UsersConnectionRepository usersConnectionRepository() {
//        JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(
//                dataSource, connectionFactoryLocator(), textEncryptor);
//        repository.setConnectionSignUp(connectionSignUp());
//        return repository;
//    }
	

//    @Bean
//    public TextEncryptor textEncryptor() {
//        return Encryptors.noOpText();
//    }
    
	
    @Bean
	public SignInAdapter signInAdapter() {
		return new MySignInAdapter(new HttpSessionRequestCache());
	}
}
