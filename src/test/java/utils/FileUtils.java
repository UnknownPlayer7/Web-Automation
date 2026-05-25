package utils;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

import static aquality.selenium.browser.AqualityServices.getLogger;

@UtilityClass
public class FileUtils {

    private final String CREATE_FILE_EXCEPTION = "Couldn't create the file at %s; Cause: %s";
    private final String CREATE_FILE_LOG = "File '%s' :: Creating at '%s'";
    private final String DELETE_FILE_LOG = "File '%s' :: Deleting at '%s'";
    private final String FILE_ALREADY_EXISTS_LOG = "File '%s' :: Creating skipped! File already exists at '%s'";
    private final String DELETE_FILE_FAIL_LOG = "File '%s' :: Deleting failure! Path: '%s'. Cause: %s";
    private final String DELETE_FILE_NOT_FOUND_LOG = "File '%s' :: Deleting skipped! File doesn't exist at '%s'";

    private final int DELETE_FILE_RETRIES = 3;
    private final int DELETE_FILE_RETRIES_POLLING = 200;

    public void createFile(Path path) {
        try {
            Files.createFile(path);
            getLogger().info(CREATE_FILE_LOG.formatted(path, path.toAbsolutePath()));
        } catch (FileAlreadyExistsException e) {
            getLogger().warn(FILE_ALREADY_EXISTS_LOG.formatted(path, path.toAbsolutePath()));
        } catch (IOException e) {
            throw new RuntimeException(CREATE_FILE_EXCEPTION.formatted(path, e));
        }
    }

    public void deleteFile(Path path) {
        for (int i = 1; i <= DELETE_FILE_RETRIES; i ++) {
            try {
                if (Files.deleteIfExists(path)) {
                    getLogger().info(DELETE_FILE_LOG.formatted(path, path.toAbsolutePath()));
                } else {
                    getLogger().info(DELETE_FILE_NOT_FOUND_LOG.formatted(path, path.toAbsolutePath()));
                }
                break;
            } catch (IOException e) {
                if(DELETE_FILE_RETRIES == i) {
                    getLogger().warn(DELETE_FILE_FAIL_LOG.formatted(path, path.toAbsolutePath(), e));
                } else {
                    retryWait(DELETE_FILE_RETRIES_POLLING);
                }
            }
        }
    }

    private void retryWait(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
