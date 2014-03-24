package net.therap.controller;

import net.therap.model.User;
import net.therap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: imranahmed
 * Date: 3/18/14
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class PageRedirectionController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/redirectToCreate", method = RequestMethod.GET)
    public String redirect() {
        return "redirect:createVCard";
    }

    @RequestMapping(value = "/searchVCard", method = RequestMethod.POST)
    public String redirectToSearchPage(HttpServletRequest httpServletRequest, ModelMap modelMap) {
        List<User> userList = userService.getUserList();
        modelMap.addAttribute("userList", userList);
        return "search";
    }

    @RequestMapping(value = "/toUserPage", method = RequestMethod.GET)
    public String redirectToAnotherController() {
        return "userPage";
    }

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public String redirectToExport() {
        return "export";
    }
}
