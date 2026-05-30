package utils;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Properties;

@UtilityClass
public class PropertiesSupplier {

    public Properties getProperties(String path) {
        try (InputStream in = PropertiesSupplier.class.getResourceAsStream(path)) {
            Properties properties = new Properties();
            properties.load(in);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
