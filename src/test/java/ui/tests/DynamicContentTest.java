package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.constants.MainPageLink;
import ui.constants.Paragraphs;
import ui.pages.DynamicContentPage;

public class DynamicContentTest extends TestBase {

    private final DynamicContentPage dynamicContentPage = new DynamicContentPage();

    @BeforeMethod(dependsOnMethods = "setup")
    @Override
    protected void navigationTest() {
        navigateAndCheck(dynamicContentPage, MainPageLink.DYNAMIC_CONTENT);
    }

    /**
     * This test method verifies that the all paragraphs have the {@code ever-changing} content
     * after refreshing the page.
     * <p>There are the {@code Data Provider} that supply the corresponding paragraphs.</p>
     */
    @Test(dataProvider = "dynamicParagraphProvider")
    public void shouldChangeParagraphContentAfterRefresh(Paragraphs paragraph) {
        String oldParagraphText = dynamicContentPage.getParagraphText(paragraph);
        dynamicContentPage.refreshPage();
        String newParagraphText = dynamicContentPage.getParagraphText(paragraph);

        Assert.assertNotEquals(newParagraphText, oldParagraphText,
                "The old text from the paragraph and the new one shouldn't be the same!");
    }

    @DataProvider
    public Object[][] dynamicParagraphProvider() {
        return new Paragraphs[][] {
                {Paragraphs.FIRST_PARAGRAPH},
                {Paragraphs.SECOND_PARAGRAPH},
                {Paragraphs.THIRD_PARAGRAPH}
        };
    }

    /**
     * This test method verifies that the two first paragraphs have the {@code static} content
     * after clicking the Static Link and refreshing the page.
     * <p>There are the {@code Data Provider} that supply the corresponding paragraphs.</p>
     */
    @Test(dataProvider = "staticParagraphProvider")
    public void shouldKeepFirstTwoParagraphsStaticAfterRefreshInStaticMode(Paragraphs paragraph) {
        dynamicContentPage.enableStaticMode();

        String oldParagraphText = dynamicContentPage.getParagraphText(paragraph);
        dynamicContentPage.refreshPage();
        String newParagraphText = dynamicContentPage.getParagraphText(paragraph);

        Assert.assertEquals(newParagraphText, oldParagraphText,
                "The paragraph text should remain the same after refreshing the page!");
    }

    @DataProvider
    public Object[][] staticParagraphProvider() {
        return new Paragraphs[][] {
                {Paragraphs.FIRST_PARAGRAPH},
                {Paragraphs.SECOND_PARAGRAPH}
        };
    }

    /**
     * This test method verifies that the third paragraph has the {@code dynamic} content
     * after clicking the Static Link and refreshing the page.
     */
    @Test
    public void shouldKeepThirdParagraphDynamicAfterRefreshInStaticMode() {
        dynamicContentPage.enableStaticMode();

        String oldParagraphText = dynamicContentPage.getParagraphText(Paragraphs.THIRD_PARAGRAPH);
        dynamicContentPage.refreshPage();
        String newParagraphText = dynamicContentPage.getParagraphText(Paragraphs.THIRD_PARAGRAPH);

        Assert.assertNotEquals(newParagraphText, oldParagraphText,
                """
                        The old text from the first paragraph and the new one shouldn't be the same
                        after clicking the Static Link and refreshing the page!
                        """);
    }
}
