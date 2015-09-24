/**
 * 
 */
package testingtools.social_login.signin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

/**
 * @author pretonik
 *
 */
@Controller
public class SigninController {

	

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String showRegistrationForm(WebRequest request, Model model) {
		return "signin";
	}

}
