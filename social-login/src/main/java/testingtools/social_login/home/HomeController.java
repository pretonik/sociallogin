/**
 * 
 */
package testingtools.social_login.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author pretonik
 *
 */
@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(Model model) {
        return "home";
	}

	
}
