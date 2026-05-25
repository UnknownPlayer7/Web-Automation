package ui.tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.constants.MainPageLink;
import ui.pages.FileUploadPage;
import utils.FileUtils;
import utils.TestDataSupplier;

import java.nio.file.Path;

public class FileUploadTest extends TestBase {

    private static final Path FILE_PATH = TestDataSupplier.getFileUploadData().getPath();
    private static final String FILE_NAME = TestDataSupplier.getFileUploadData().getFileName();
    private final FileUploadPage fileUploadPage = new FileUploadPage();

    @BeforeMethod(dependsOnMethods = "setup")
    @Override
    protected void navigationTest() {
        navigateAndCheck(fileUploadPage, MainPageLink.FILE_UPLOAD);
    }

    @BeforeMethod(dependsOnMethods = "navigationTest")
    public void createFile() {
        FileUtils.createFile(FILE_PATH);
    }

    @Test
    public void fileUploadPage() {
        fileUploadPage.enterFilePath(FILE_PATH);
        fileUploadPage.clickUploadButton();

        Assert.assertTrue(fileUploadPage.getUploadedFiles().contains(FILE_NAME),
                "The List of uploaded files doesn't contain the uploaded file '%s'".formatted(FILE_NAME));
    }

    @AfterMethod
    public void deleteFile() {
        FileUtils.deleteFile(FILE_PATH);
    }
}
