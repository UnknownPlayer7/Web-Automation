package ui.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import ui.constants.Paragraphs;

import java.util.List;

public class DynamicContentPage extends Form {

    private final ILink staticLink = getElementFactory().getLink(
            By.xpath("//*[@href='/dynamic_content?with_content=static']"), "Static Link");

    public DynamicContentPage() {
        super(By.xpath("//*[text()='Dynamic Content']"), "Dynamic Content Page");
    }

    public String getParagraphText(Paragraphs paragraph) {
        List<ILabel> paragraphs = getParagraphs();

        return paragraphs.get(paragraph.getParagraphOrder()).getText();
    }

    private List<ILabel> getParagraphs() {
        return getElementFactory().findElements(
                By.xpath("//*[@id='content']//div[@class='large-10 columns']"),"Paragraph", ElementType.LABEL);
    }

    public void enableStaticMode() {
        staticLink.click();
    }
}
