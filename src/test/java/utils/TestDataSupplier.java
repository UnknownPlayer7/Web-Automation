package utils;

import lombok.experimental.UtilityClass;
import api.models.AuthData;
import ui.models.Env;
import ui.models.EnvData;

import java.nio.file.Path;

@UtilityClass
public class TestDataSupplier {

    private final Path RESOURCES_FOLDER_PATH = Path.of("src/test/resources");
    private final Path ENVIRONMENT_FOLDER_PATH = RESOURCES_FOLDER_PATH.resolve("environment");
    private final Path ENV_FILE_PATH = RESOURCES_FOLDER_PATH.resolve("env.json");

    private final Path TEST_DATA_FOLDER_PATH = RESOURCES_FOLDER_PATH.resolve("test-data");
    private final Path AUTH_DATA_FILE_PATH = TEST_DATA_FOLDER_PATH.resolve("auth-data.json");

    public EnvData getEnvData() {
        String currentEnvironment = "%s.json".formatted(getEnv().getEnv());

        return JsonUtils.deserialize(ENVIRONMENT_FOLDER_PATH.resolve(currentEnvironment), EnvData.class);
    }

    private Env getEnv() {
        return JsonUtils.deserialize(ENV_FILE_PATH, Env.class);
    }

    public AuthData getAuthData() {
        return JsonUtils.deserialize(AUTH_DATA_FILE_PATH, AuthData.class);
    }
}
