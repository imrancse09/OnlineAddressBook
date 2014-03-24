package net.therap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: imranahmed
 * Date: 2/3/14
 * Time: 2:32 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class LogOutController {
    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String redirectToLoginPage(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession(false).invalidate();
        return "login";
    }
}
