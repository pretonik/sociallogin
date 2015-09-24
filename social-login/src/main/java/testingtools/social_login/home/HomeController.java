/**
 * 
 */
package testingtools.social_login.home;

import javax.inject.Inject;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author pretonik
 *
 */
@Controller
@SessionAttributes("twitterProfile")
public class HomeController {

	 private Twitter twitter;

	 private ConnectionRepository connectionRepository;
	
	@Inject
	public HomeController(Twitter twitter,
			ConnectionRepository connectionRepository) {
		this.twitter = twitter;
		this.connectionRepository = connectionRepository;
	}

	@RequestMapping("/")
	public String home(Model model) {
//       return "home";
       
       if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
           return "home";
       }

       model.addAttribute(twitter.userOperations().getUserProfile());
       CursoredList<TwitterProfile> friends = retrieveFriends();
       model.addAttribute("friends", friends);
       return "hello";
	}

	/**
	 * @return
	 */
	@Cacheable(key="retrieveFriends")
	public CursoredList<TwitterProfile> retrieveFriends() {
		CursoredList<TwitterProfile> friends = twitter.friendOperations().getFriends();
		return friends;
	}
}
