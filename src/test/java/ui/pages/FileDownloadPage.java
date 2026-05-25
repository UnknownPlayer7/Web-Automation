package ui.pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class FileDownloadPage extends Form {

    public FileDownloadPage() {
        super(By.xpath("//*[text()='File Downloader']"), "File Download Page");
    }

    public boolean isDownloadLinkDisplayed(String fileName) {
        return getLinkByFileName(fileName).state().waitForDisplayed();
    }

    public void downloadFile(String fileName) {
        getLinkByFileName(fileName).click();
    }

    private ILink getLinkByFileName(String fileName) {
        return getElementFactory().getLink(
                By.xpath("//a[@href='download/%s']".formatted(fileName)), fileName);
    }
}
