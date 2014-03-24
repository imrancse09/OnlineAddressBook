package net.therap.controller;

import net.therap.format.VCardFormat;
import net.therap.model.VCard;
import net.therap.service.VCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: imranahmed
 * Date: 3/19/14
 * Time: 2:25 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class ExportController extends HttpServlet {
    @Autowired
    private VCardService vCardService;

    VCard vCardById = new VCard();

    private static final int BYTES_DOWNLOAD = 1024;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @RequestMapping(value = "/downloadFile", method = RequestMethod.POST)
    public String exportContacts(HttpServletRequest request, ModelMap modelMap, HttpServletResponse
            httpServletResponse) {
        int returnedRowId = Integer.parseInt(request.getParameter("exportButton"));


        String exportButton = request.getParameter("export");
        String updateButton = request.getParameter("update");
        String deleteButton = request.getParameter("delete");

        vCardById = vCardService.getVCardById(returnedRowId);

        if (exportButton != null) {

            String s = VCardFormat.BEGIN + "VCARD" + "\n" +
                    VCardFormat.VERSION + "3.0" + "\n" +
                    VCardFormat.NAME + vCardById.getN() + "\n" +
                    VCardFormat.FULL_NAME + vCardById.getFN() + "\n" +
                    VCardFormat.ORGANIZATION + vCardById.getOrganization() + "\n" +
                    VCardFormat.TITLE + vCardById.getJobTitle() + "\n" +
                    VCardFormat.PHOTO + vCardById.getPhotoUrl() + "\n" +
                    VCardFormat.TELEPHONE_WORK + vCardById.getPhoneWork() + "\n" +
                    VCardFormat.TELEPHONE_HOME + "\n" + vCardById.getPhoneHome() +
                    VCardFormat.ADDRESS_WORK + vCardById.getAddressWork() + "\n" +
                    VCardFormat.LABEL_WORK + vCardById.getLabelWork() + "\n" +
                    VCardFormat.ADDRESS_HOME + vCardById.getAddressHome() + "\n" +
                    VCardFormat.LABEL_HOME + vCardById.getLabelHome() + "\n" +
                    VCardFormat.EMAIL_PREF + vCardById.getPrefEmail() + "\n" +
                    VCardFormat.REVISION + vCardById.getRevision() + "\n" +
                    VCardFormat.END + VCardFormat.BEGIN_END_VALUE;


            httpServletResponse.setContentType("text/plain");
            httpServletResponse.setHeader("Content-Disposition", "attachment;filename=" +
                    "downloadFile.vcf");


            InputStream input = null;
            try {
                input = new ByteArrayInputStream(s.getBytes("UTF8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            int read = 0;
            byte[] bytes = new byte[BYTES_DOWNLOAD];
            OutputStream os = null;
            try {
                os = httpServletResponse.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                while ((read = input.read(bytes)) != -1) {
                    os.write(bytes, 0, read);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.flush();
                os.close();
            } catch (IOException e) {
            }
        } else if (updateButton != null) {
            modelMap.addAttribute("vCardById", vCardById);
            return "update_vCard";

        } else if (deleteButton != null) {
            vCardService.deleteVCard(vCardById.getvCardPKey());
            return "deleteSuccessful";
        }

        return "successfulExport";

    }
}
