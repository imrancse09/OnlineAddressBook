package net.therap.controller;

import net.therap.format.VCardFormat;
import net.therap.model.User;
import net.therap.model.VCard;
import net.therap.service.VCardService;
import net.therap.validator.VCardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: imranahmed
 * Date: 3/18/14
 * Time: 3:48 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class CreateVCardController {
    @Autowired
    private VCardService vCardService;

    @Autowired
    private VCardValidator vCardValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(vCardValidator);
    }

    @RequestMapping(value = "/createVCard", method = RequestMethod.GET)
    public String createNew(ModelMap modelMap) {

        VCard vCard = new VCard();
        modelMap.put("vCard", vCard);
        return "createVCard";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submitItem(@Valid @ModelAttribute(value = "vCard") VCard vCard, BindingResult
            result, HttpServletRequest httpServletRequest) {

        User userObj = (User) httpServletRequest.getSession().getAttribute("user");

        if (result.hasErrors()) {
            return "createVCard";
        }

        vCard.setUser(userObj);
        vCardService.createVCard(vCard);


        BufferedWriter bufferWriter;
        try {
            bufferWriter = new BufferedWriter(new FileWriter(new File("/home/imranahmed/" +
                    "IdeaProjects/OnlineAddressBook/" + "contact" + System.currentTimeMillis() + ".vcf"),
                    false));

            bufferWriter.write(VCardFormat.BEGIN + "VCARD");
            bufferWriter.newLine();
            bufferWriter.write(VCardFormat.VERSION + "3.0");
            bufferWriter.newLine();
            bufferWriter.write(VCardFormat.NAME + vCard.getN());
            bufferWriter.newLine();
            bufferWriter.write(VCardFormat.FULL_NAME + vCard.getFN());
            bufferWriter.newLine();
            bufferWriter.write(VCardFormat.ORGANIZATION + vCard.getOrganization());
            bufferWriter.newLine();
            bufferWriter.write(VCardFormat.TITLE + vCard.getJobTitle());
            bufferWriter.newLine();
            bufferWriter.write(VCardFormat.PHOTO + vCard.getPhotoUrl());
            bufferWriter.newLine();
            bufferWriter.write(VCardFormat.TELEPHONE_WORK + vCard.getPhoneWork());
            bufferWriter.newLine();
            bufferWriter.write(VCardFormat.TELEPHONE_HOME + vCard.getPhoneHome());
            bufferWriter.newLine();
            bufferWriter.write(VCardFormat.ADDRESS_WORK + vCard.getAddressWork());
            bufferWriter.newLine();
            bufferWriter.write(VCardFormat.LABEL_WORK + vCard.getLabelWork());
            bufferWriter.newLine();
            bufferWriter.write(VCardFormat.ADDRESS_HOME + vCard.getAddressHome());
            bufferWriter.newLine();
            bufferWriter.write(VCardFormat.LABEL_HOME + vCard.getLabelHome());
            bufferWriter.newLine();
            bufferWriter.write(VCardFormat.EMAIL_PREF + vCard.getPrefEmail());
            bufferWriter.newLine();
            bufferWriter.write(VCardFormat.REVISION + vCard.getRevision());
            bufferWriter.newLine();
            bufferWriter.write(VCardFormat.END + VCardFormat.BEGIN_END_VALUE);
            bufferWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "success";
    }
}
