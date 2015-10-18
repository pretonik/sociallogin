/**
 * 
 */
package testingtools.social_login.twitter;

import java.security.Principal;

import javax.inject.Inject;

import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author pretonik
 *
 */
@Controller
public class ProfileController {

	private final Twitter twitter;

	@Inject
	public ProfileController(Twitter twitter) {
		this.twitter = twitter;
	}
	
	@RequestMapping(value="/twitter/profile", method=RequestMethod.GET)
	public String home(Principal currentUser, Model model) {
		model.addAttribute("profile", twitter.userOperations().getUserProfile());
		return "twitter/profile";
	}
}
