package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.constants.Arrows;
import ui.constants.MainPageLink;
import ui.pages.HorizontalSliderPage;
import utils.TestDataSupplier;

public class HorizontalSliderTest extends TestBase {

    private static final String VALUE = TestDataSupplier.getSliderBarData().getValue();
    private static final int ARROW_RIGHT = TestDataSupplier.getSliderBarData().getArrowRight();
    private static final int ARROW_LEFT = TestDataSupplier.getSliderBarData().getArrowLeft();
    private static final String INITIAL_VALUE = "0";
    private final HorizontalSliderPage horizontalSliderPage = new HorizontalSliderPage();

    @BeforeMethod(dependsOnMethods = "setup")
    @Override
    protected void navigationTest() {
        navigateAndCheck(horizontalSliderPage, MainPageLink.HORIZONTAL_SLIDER);
    }

    @Test
    public void horizontalSliderSetByValueTest() {
        Assert.assertEquals(horizontalSliderPage.getSliderRange(), INITIAL_VALUE,
                "The expected slider bar range doesn't match the actual one!");

        horizontalSliderPage.setSliderBarValue(VALUE);

        Assert.assertEquals(horizontalSliderPage.getSliderRange(), VALUE,
                "The expected slider bar range doesn't match the actual one!");
    }

    @Test
    public void horizontalSliderSetByArrowsTest() {
        Assert.assertEquals(horizontalSliderPage.getSliderRange(), INITIAL_VALUE,
                "The expected slider bar range doesn't match the actual one!");

        for (int i = 0; i < ARROW_RIGHT; i++) {
            horizontalSliderPage.shiftSliderByArrow(Arrows.RIGHT);
        }
        for (int i = 0; i < ARROW_LEFT; i++) {
            horizontalSliderPage.shiftSliderByArrow(Arrows.LEFT);
        }

        Assert.assertEquals(horizontalSliderPage.getSliderRange(), VALUE,
                "The expected slider bar range doesn't match the actual one!");
    }
}
