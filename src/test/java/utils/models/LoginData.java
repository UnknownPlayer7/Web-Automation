package utils.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginData {
    private final String username;
    private final String password;
    private final String url;
}
