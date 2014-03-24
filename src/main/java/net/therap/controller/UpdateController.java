package net.therap.controller;

import net.therap.model.VCard;
import net.therap.service.VCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: imranahmed
 * Date: 3/24/14
 * Time: 12:53 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UpdateController {
    @Autowired
    private VCardService vCardService;

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String submitItem(@ModelAttribute(value = "vCardById") VCard vCardById, HttpServletRequest httpServletRequest) {
        int id = vCardById.getvCardPKey();
        vCardService.updateVCard(id, vCardById);
        return "successfulUpdate";
    }
}
