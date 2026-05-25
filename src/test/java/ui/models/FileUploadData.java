package ui.models;

import lombok.Getter;

import java.nio.file.Path;

@Getter
public class FileUploadData {

    private String fileName;

    public Path getPath() {
        return Path.of(fileName);
    }
}
