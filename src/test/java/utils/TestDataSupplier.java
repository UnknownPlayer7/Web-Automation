package utils;

import lombok.experimental.UtilityClass;
import api.models.AuthData;
import ui.models.*;

import java.nio.file.Path;

@UtilityClass
public class TestDataSupplier {

    private final Path RESOURCES_FOLDER_PATH = Path.of("src/test/resources");
    private final Path ENVIRONMENT_FOLDER_PATH = RESOURCES_FOLDER_PATH.resolve("environment");
    private final Path ENV_FILE_PATH = RESOURCES_FOLDER_PATH.resolve("env.json");

    private final Path TEST_DATA_FOLDER_PATH = RESOURCES_FOLDER_PATH.resolve("test-data");
    private final Path AUTH_DATA_FILE_PATH = TEST_DATA_FOLDER_PATH.resolve("auth-data.json");
    private final Path DISAPPEARING_ELEMENTS_DATA_FILE_PATH = TEST_DATA_FOLDER_PATH.resolve("disappearing-elements-data.json");
    private final Path DRAG_AND_DROP_DATA_FILE_PATH = TEST_DATA_FOLDER_PATH.resolve("drag-and-drop-data.json");
    private final Path DYNAMIC_CONTROLS_DATA_FILE_PATH = TEST_DATA_FOLDER_PATH.resolve("dynamic-controls-data.json");

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

    public DisappearingElementsData getDisappearingElementsData() {
        return JsonUtils.deserialize(DISAPPEARING_ELEMENTS_DATA_FILE_PATH, DisappearingElementsData.class);
    }

    public DragAndDropData getDragAndDropData() {
        return JsonUtils.deserialize(DRAG_AND_DROP_DATA_FILE_PATH, DragAndDropData.class);
    }

    public DynamicControlsData getDynamicControlsData() {
        return JsonUtils.deserialize(DYNAMIC_CONTROLS_DATA_FILE_PATH, DynamicControlsData.class);
    }
}
