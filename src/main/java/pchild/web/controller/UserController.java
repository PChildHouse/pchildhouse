package pchild.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pchild.domain.User;
import pchild.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * User: guibin
 * Date: 4/13/14
 * Time: 8:44 PM
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, BindingResult bindingResult, Model uiModel,
                        HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("message", "Error!");
            return "login";
        }

        uiModel.asMap().clear();

        if (userService.isValid(user.getUsername(), user.getPassword())) {
            uiModel.addAttribute("message", "Password Correct");
        }else {
            uiModel.addAttribute("message", "Wrong username or password");
        }

        return "login";
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
