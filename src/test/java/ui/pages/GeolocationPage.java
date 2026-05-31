package ui.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.models.Position;

public class GeolocationPage extends Form {

    private final IButton geolocationButton = getElementFactory().getButton(By.xpath(
            "//*[@onclick='getLocation()']"), "'Where am I?' Button");
    private final ILabel latitudeLabel = getElementFactory().getLabel(By.id("lat-value"), "Latitude Label");
    private final ILabel longitudeLabel = getElementFactory().getLabel(By.id("long-value"), "Longitude Label");

    public GeolocationPage() {
        super(By.xpath("//*[text()='Geolocation']"), "Geolocation Page");
    }

    public void determineGeolocation() {
        geolocationButton.click();
    }

    public Position getDeterminedPosition() {
        String determinedLatitude = getLatitude();
        String determinedLongitude = getLongitude();

        return new Position(determinedLongitude, determinedLatitude);
    }

    public String getLatitude() {
        return latitudeLabel.getText().trim();
    }

    public String getLongitude() {
        return longitudeLabel.getText().trim();
    }
}
