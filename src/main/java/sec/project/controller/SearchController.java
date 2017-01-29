package sec.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.repository.SignupRepositoryImpl;

@Controller
public class SearchController {

    @Autowired
    private SignupRepositoryImpl signupRepository;
    
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String submitForm(Authentication authentication, Model model,
            @RequestParam String searchName) {
        User user = (User) authentication.getPrincipal();
        model.addAttribute("list" , signupRepository.getSignupsByName(searchName, user.getUsername()));
        return "search";
    }
}
