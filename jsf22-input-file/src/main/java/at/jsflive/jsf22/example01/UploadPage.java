package at.jsflive.jsf22.example01;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@ManagedBean
@ViewScoped
public class UploadPage {
    private Part uploadedFile;
    private String fileContent;

    public void validateFile(FacesContext ctx, UIComponent comp, Object value) {
        List<FacesMessage> msgs = new ArrayList<FacesMessage>();
        Part file = (Part)value;
        if (file.getSize() > 1024) {
            msgs.add(new FacesMessage("file too big"));
        }
        if (!"text/plain".equals(file.getContentType())) {
            msgs.add(new FacesMessage("not a text file"));
        }
        if (!msgs.isEmpty()) {
            throw new ValidatorException(msgs);
        }
    }

    public void uploadFile() {
        try {
            fileContent = new Scanner(uploadedFile.getInputStream()).useDelimiter("\\A").next();
        } catch (IOException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                "error uploading file",
                                                null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public String getFileContent() {
        return fileContent;
    }

}
