package net.therap.controller;

import net.therap.dao.UserDao;
import net.therap.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: imranahmed
 * Date: 3/18/14
 * Time: 12:00 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(method = RequestMethod.GET)
    public String firstPage() {
        return "login";
    }

    @RequestMapping(value = "/userPage", method = RequestMethod.POST)
    public String loginSuccess(@RequestParam("txtName") String name,
                               @RequestParam("txtPassword") String password,
                               HttpServletRequest httpServletRequest,
                               HttpSession httpSession,
                               ModelMap modelMap) {

        User user = userDao.checkLogin(name, password);
        if (user == null) {
            modelMap.addAttribute("error", true);
            return "login";
        }
        if (user != null) {
            httpSession = httpServletRequest.getSession(true);
            if (httpServletRequest.getSession(false) != null) {
                httpServletRequest.getSession().setAttribute("user", user);

                return "userPage";
            }
        }
        return "login";
    }
}

