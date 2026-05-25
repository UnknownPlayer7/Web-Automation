package ui.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.nio.file.Path;

public class FileUploadPage extends Form {

    private final IButton uploadButton = getElementFactory().getButton(
            By.id("file-submit"), "Upload Button");
    private final ITextBox inputFileUpload = getElementFactory().getTextBox(
            By.id("file-upload"), "Input File Upload");
    private final ILabel uploadedFilesList = getElementFactory().getLabel(By.id("uploaded-files"),
            "Uploaded Files List");

    public FileUploadPage() {
        super(By.xpath("//*[text()='File Uploader']"), "File Upload Page");
    }

    public void enterFilePath(Path path) {
        inputFileUpload.type(path.toAbsolutePath().toString());
    }

    public void clickUploadButton() {
        uploadButton.click();
    }

    public String getUploadedFiles() {
        return uploadedFilesList.getText();
    }
}
