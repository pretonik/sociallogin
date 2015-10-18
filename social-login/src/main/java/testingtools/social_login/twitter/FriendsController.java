package testingtools.social_login.twitter;

import javax.inject.Inject;

import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FriendsController {

	private final Twitter twitter;
	
	@Inject
	public FriendsController(Twitter twitter) {
		this.twitter = twitter;
	}
	
	@RequestMapping(value="/twitter/friends", method=RequestMethod.GET)
	public String friends(Model model) {
		model.addAttribute("twitterProfile", twitter.userOperations().getUserProfile());
		model.addAttribute("friends", twitter.friendOperations().getFriends());
		return "twitter/friends";
	}

	@RequestMapping(value="/twitter/followers", method=RequestMethod.GET)
	public String followers(Model model) {
		model.addAttribute("twitterProfile", twitter.userOperations().getUserProfile());
		model.addAttribute("friends", twitter.friendOperations().getFollowers());
		return "twitter/friends";
	}
}
