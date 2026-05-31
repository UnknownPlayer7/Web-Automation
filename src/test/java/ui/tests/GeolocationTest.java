package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.constants.MainPageLink;
import ui.pages.GeolocationPage;
import utils.BrowserUtils;
import utils.TestDataSupplier;
import utils.models.Position;

public class GeolocationTest extends TestBase {

    private final GeolocationPage geolocationPage = new GeolocationPage();

    @BeforeMethod(dependsOnMethods = "setup")
    @Override
    protected void navigationTest() {
        navigateAndCheck(geolocationPage, MainPageLink.GEOLOCATION);
    }

    @Test
    public void geolocationTest() {
        geolocationPage.determineGeolocation();
        Position determinedPosition = geolocationPage.getDeterminedPosition();
        Position expectedPosition = BrowserUtils.getCurrentPosition();

        Assert.assertEquals(determinedPosition, expectedPosition,
                "The determined position doesn't match the expected one!");
    }

    @Test(dataProvider = "geolocationProvider")
    public void emulateLocationTest(Position expectedPosition) {
        BrowserUtils.emulatePosition(expectedPosition);

        geolocationPage.determineGeolocation();
        Position determinedPosition = geolocationPage.getDeterminedPosition();

        Assert.assertEquals(determinedPosition, expectedPosition,
                "The determined position doesn't match the expected one!");
    }

    @DataProvider
    public Position[][] geolocationProvider() {
        return TestDataSupplier.getGeolocationData();
    }
}
