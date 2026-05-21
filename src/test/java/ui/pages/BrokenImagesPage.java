package ui.pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class BrokenImagesPage extends Form {

    private List<ILink> images;

    public BrokenImagesPage() {
        super(By.xpath("//img[@src='img/avatar-blank.jpg']"), "Broken Images Page");
    }

    public List<String> getBrokenImages() {
        images = getElementFactory().findElements(By.tagName("img"), "Image", ILink.class);

        return images.stream()
                .map(image -> image.getAttribute("src"))
                .filter(href -> getResponseStatusCode(href) != 200)
                .toList();
    }

    private int getResponseStatusCode(String link) {
        try(HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder(URI.create(link)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.statusCode();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
