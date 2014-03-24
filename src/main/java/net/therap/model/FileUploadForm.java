package net.therap.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created with IntelliJ IDEA.
 * User: imranahmed
 * Date: 3/23/14
 * Time: 4:56 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.List;

public class FileUploadForm {
    private List<MultipartFile> files;


    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }
}
