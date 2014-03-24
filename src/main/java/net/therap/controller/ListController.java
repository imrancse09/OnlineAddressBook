package net.therap.controller;

import net.therap.model.User;
import net.therap.model.VCard;
import net.therap.service.VCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Imran
 * Date: 3/18/14
 * Time: 11:55 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ListController {
    @Autowired
    private VCardService vCardService;

    @RequestMapping(value = "/showVCard", method = RequestMethod.GET)
    public String vCardShow(HttpServletRequest request, ModelMap modelMap) {
        User userObj = (User) request.getSession().getAttribute("user");
        List<VCard> vCardList = vCardService.retrieveVCardByUser(userObj);
        modelMap.addAttribute("vCardList", vCardList);
        return "showVCard";
    }
}
