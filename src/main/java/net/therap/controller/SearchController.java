package net.therap.controller;

import net.therap.model.User;
import net.therap.model.VCard;
import net.therap.service.VCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: imranahmed
 * Date: 3/18/14
 * Time: 11:12 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class SearchController {
    @Autowired
    private VCardService vCardService;

    @RequestMapping(value = "/searchResult", method = RequestMethod.POST)
    public String searchResult(@RequestParam("jspFirstName") String jspFirstName, ModelMap modelMap,
                               HttpServletRequest httpServletRequest) {
        User userObj = (User) httpServletRequest.getSession().getAttribute("user");
        List<VCard> vCardSearchList = vCardService.retrieveVCardListByUser(jspFirstName, userObj);
        modelMap.addAttribute("vCardSearchList", vCardSearchList);
        return "search";
    }
}
