package ui.models;

import lombok.Getter;

@Getter
public class EnvData {
    private String protocol;
    private String domain;
    private int wait;

    public String getHost() {
        return "%s://%s".formatted(protocol, domain);
    }
}
