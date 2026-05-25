package ui.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.constants.MainPageLink;
import ui.pages.FileDownloadPage;
import utils.FileUtils;
import utils.TestDataSupplier;

import java.nio.file.Path;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class FileDownloadTest extends TestBase {

    private static final String FILE_NAME;
    private static final Path DOWNLOADED_FILE_PATH;
    private final FileDownloadPage fileDownloadPage = new FileDownloadPage();

    static {
        FILE_NAME = TestDataSupplier.getFileUploadData().getFileName();
        DOWNLOADED_FILE_PATH = Path.of(getBrowser().getDownloadDirectory(), FILE_NAME);
    }

    @BeforeMethod(dependsOnMethods = "setup")
    @Override
    protected void navigationTest() {
        navigateAndCheck(fileDownloadPage, MainPageLink.FILE_DOWNLOAD);
    }

    @Test
    public void fileDownloadTest() {
        Assert.assertTrue(fileDownloadPage.isDownloadLinkDisplayed(FILE_NAME),
                "The required download link '%s' isn't displayed!".formatted(FILE_NAME));
        fileDownloadPage.downloadFile(FILE_NAME);

        Assert.assertTrue(FileUtils.isFileExists(DOWNLOADED_FILE_PATH),
                "The file doesn't exist at '%s'".formatted(DOWNLOADED_FILE_PATH));
    }

    @AfterMethod
    public void deleteFile() {
        FileUtils.deleteFile(DOWNLOADED_FILE_PATH);
    }
}
