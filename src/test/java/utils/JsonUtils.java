package utils;

import aquality.selenium.browser.AqualityServices;
import com.google.gson.Gson;
import lombok.experimental.UtilityClass;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

@UtilityClass
public class JsonUtils {

    private final String ERROR_MESSAGE = "Could not deserialize file at %s. Cause: %s";

    public  <T> T deserialize(Path path, Class<T> tClass) {
        try(FileReader reader = new FileReader(path.toFile())) {
            return new Gson().fromJson(reader, tClass);
        } catch (IOException e) {
            AqualityServices.getLogger().error(ERROR_MESSAGE.formatted(path, e));
            throw new RuntimeException(ERROR_MESSAGE.formatted(path, e));
        }
    }
}
