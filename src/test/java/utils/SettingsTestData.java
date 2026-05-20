package utils;

import aquality.selenium.browser.AqualityServices;
import com.google.gson.Gson;
import lombok.experimental.UtilityClass;
import models.BasicAuthData;
import models.Env;
import models.EnvData;

import java.io.FileReader;
import java.io.IOException;

@UtilityClass
public class SettingsTestData {

    private final String RESOURCES_FOLDER_PATH = "src\\test\\resources\\";
    private final String ENVIRONMENT_FILE_PATH_PATTERN = RESOURCES_FOLDER_PATH + "environment\\%s.json";
    private final String ENV_FILE_PATH = RESOURCES_FOLDER_PATH + "env.json";

    private final String TEST_DATA_FOLDER_PATH = RESOURCES_FOLDER_PATH + "test-data\\";
    private final String BASIC_AUTH_DATA_FILE_PATH = TEST_DATA_FOLDER_PATH + "basic-auth-data.json";

    private final String ERROR_MESSAGE = "Could not deserialize file at %s. Cause: %s";

    public EnvData getEnvData() {
        return deserialize(ENVIRONMENT_FILE_PATH_PATTERN.formatted(getEnv().getEnv()), EnvData.class);
    }

    private Env getEnv() {
        return deserialize(ENV_FILE_PATH, Env.class);
    }

    private <T> T deserialize(String path, Class<T> tClass) {
        try(FileReader reader = new FileReader(path)) {
            return new Gson().fromJson(reader, tClass);
        } catch (IOException e) {
            AqualityServices.getLogger().error(ERROR_MESSAGE.formatted(path, e));
            throw new RuntimeException(ERROR_MESSAGE.formatted(path, e));
        }
    }

    public BasicAuthData getBasicAuthData() {
        return deserialize(BASIC_AUTH_DATA_FILE_PATH, BasicAuthData.class);
    }
}
