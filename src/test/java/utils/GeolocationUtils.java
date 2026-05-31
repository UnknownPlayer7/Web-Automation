package utils;

import lombok.experimental.UtilityClass;
import utils.models.Position;

import static aquality.selenium.browser.AqualityServices.getBrowser;

@UtilityClass
public class GeolocationUtils {

    public Position getCurrentPosition() {
        String json = (String) getBrowser().executeAsyncScript(getGeolocationScript());

        return JsonUtils.deserialize(json, Position.class);
    }

    private String getGeolocationScript() {
        return """
                var callback = arguments[arguments.length - 1];
                navigator.geolocation.getCurrentPosition(
                    function(position) {
                        callback(JSON.stringify({latitude: position.coords.latitude, longitude: position.coords.longitude}));
                    },
                    function(error) {
                        callback(JSON.stringify({error: error.message}));
                    }
                );
                """;
    }

}
