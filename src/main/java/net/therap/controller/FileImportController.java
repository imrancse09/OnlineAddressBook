package net.therap.controller;

import net.therap.model.FileUploadForm;
import net.therap.model.User;
import net.therap.model.VCard;
import net.therap.service.VCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: imranahmed
 * Date: 3/23/14
 * Time: 4:17 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class FileImportController {
    @Autowired
    private VCardService vCardService;

    VCard vCardById = new VCard();

    StringTokenizer stringTokenizer;
    Scanner scanner;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String displayForm() {
        return "file_upload_form";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String save(@ModelAttribute("uploadForm") FileUploadForm uploadForm, Model map, HttpServletRequest httpServletRequest) {
        List<MultipartFile> files;


        files = uploadForm.getFiles();


        List<String> fileNames = new ArrayList<String>();

        if (null != files && files.size() > 0) {
            for (MultipartFile multipartFile : files) {

                String fileName = multipartFile.getOriginalFilename();
                if (fileName == null) {
                    return "file_upload_form";
                }
                if (fileName.endsWith(".vcf")) {
                    InputStream fileInputStream = null;
                    try {
                        fileInputStream = multipartFile.getInputStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    fileNames.add(fileName);

                    User userObj = (User) httpServletRequest.getSession().getAttribute("user");
                    vCardById.setUser(userObj);
                    List<String> list = new ArrayList<String>();

                    DataInputStream in = new DataInputStream(fileInputStream);
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    String line;

                    try {
                        while ((line = br.readLine()) != null) {
                            list.add(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    String line3 = list.get(2);
                    String nameLine3 = null;
                    stringTokenizer = new StringTokenizer(line3, ":");
                    while (stringTokenizer.hasMoreElements()) {
                        String secondElement = stringTokenizer.nextToken();
                        nameLine3 = secondElement;
                    }


                    scanner = new Scanner(nameLine3);

                    while (scanner.hasNextLine()) {
                        String finalLine = scanner.nextLine();
                        String[] details = finalLine.split(";");
                        String lastName = details[0];
                        String firstName = details[1];
                        String title = details[2];
                        vCardById.setLastName(lastName);
                        vCardById.setFirstName(firstName);
                        vCardById.setJobTitle(title);
                    }

                    String line5 = list.get(4);
                    String orgLine5 = null;
                    stringTokenizer = new StringTokenizer(line5, ":");
                    while (stringTokenizer.hasMoreElements()) {
                        String secondElement = stringTokenizer.nextToken();
                        orgLine5 = secondElement;
                    }

                    vCardById.setOrganization(orgLine5);

                    String line6 = list.get(5);
                    String titleLine6 = null;
                    stringTokenizer = new StringTokenizer(line6, ":");
                    while (stringTokenizer.hasMoreElements()) {
                        String secondElement = stringTokenizer.nextToken();
                        titleLine6 = secondElement;
                    }
                    vCardById.setJobTitle(titleLine6);

                    String line7 = list.get(6);
                    String photoLine7 = null;
                    stringTokenizer = new StringTokenizer(line7, ":");
                    while (stringTokenizer.hasMoreElements()) {
                        String secondElement = stringTokenizer.nextToken();
                        photoLine7 = secondElement;
                    }
                    vCardById.setPhotoUrl(photoLine7);

                    String line8 = list.get(7);
                    String telWork8 = null;
                    stringTokenizer = new StringTokenizer(line8, ":");
                    while (stringTokenizer.hasMoreElements()) {
                        String secondElement = stringTokenizer.nextToken();
                        telWork8 = secondElement;
                    }
                    vCardById.setPhoneWork(telWork8);

                    String line9 = list.get(8);
                    String telWork9 = null;
                    stringTokenizer = new StringTokenizer(line9, ":");
                    while (stringTokenizer.hasMoreElements()) {
                        String secondElement = stringTokenizer.nextToken();
                        telWork9 = secondElement;
                    }
                    vCardById.setPhoneWork(telWork9);

                    String line10 = list.get(9);
                    String adrWork10 = null;
                    stringTokenizer = new StringTokenizer(line10, ":");
                    while (stringTokenizer.hasMoreElements()) {
                        String secondElement = stringTokenizer.nextToken();
                        adrWork10 = secondElement;

                    }

                    scanner = new Scanner(adrWork10);

                    while (scanner.hasNextLine()) {
                        String finalLine = scanner.nextLine();
                        String[] details = finalLine.split(";");
                        String postBoxOfficeWork = details[0];
                        String houseNumberWork = details[1];
                        String streetWork = details[2];
                        String cityWork = details[3];
                        String stateWork = details[4];
                        String postalCodeWork = details[5];
                        String countryWork = details[6];
                        vCardById.setPostOfficeBoxWork(postBoxOfficeWork);
                        vCardById.setHouseNumberWork(houseNumberWork);
                        vCardById.setStreetWork(streetWork);
                        vCardById.setCityWork(cityWork);
                        vCardById.setStateWork(stateWork);
                        vCardById.setPostalCodeWork(postalCodeWork);
                        vCardById.setCountryWork(countryWork);
                    }

                    String line12 = list.get(11);
                    String adrWork12 = null;
                    stringTokenizer = new StringTokenizer(line12, ":");
                    while (stringTokenizer.hasMoreElements()) {
                        String secondElement = stringTokenizer.nextToken();
                        adrWork12 = secondElement;

                    }

                    scanner = new Scanner(adrWork12);

                    while (scanner.hasNextLine()) {
                        String finalLine = scanner.nextLine();
                        String[] details = finalLine.split(";");
                        String postBoxOfficeHome = details[0];
                        String houseNumberHome = details[1];
                        String streetHome = details[2];
                        String cityHome = details[3];
                        String stateHome = details[4];
                        String postalCodeHome = details[5];
                        String countryHome = details[6];
                        vCardById.setPostOfficeBoxHome(postBoxOfficeHome);
                        vCardById.setHouseNumberHome(houseNumberHome);
                        vCardById.setStreetHome(streetHome);
                        vCardById.setCityHome(cityHome);
                        vCardById.setStateHome(stateHome);
                        vCardById.setPostalCodeHome(postalCodeHome);
                        vCardById.setCountryHome(countryHome);
                    }

                    String line14 = list.get(13);
                    String emailLine14 = null;
                    stringTokenizer = new StringTokenizer(line14, ":");
                    while (stringTokenizer.hasMoreElements()) {
                        String secondElement = stringTokenizer.nextToken();
                        emailLine14 = secondElement;
                    }
                    vCardById.setPrefEmail(emailLine14);

                    String line15 = list.get(14);
                    String str = line15.substring(4);

                    vCardById.setRevision(str);
                    vCardById.getRevision();


                    vCardService.createVCard(vCardById);
                } else return "file_upload_form";

            }
        }

        map.addAttribute("files", fileNames);
        return "file_upload_success";
    }
}
