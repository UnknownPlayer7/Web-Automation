package utils.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Rectangle {

    private double top;
    private double left;
    private double bottom;
    private double right;

    @Override
    public String toString() {
        return "(%.0f;%.0f); (%.0f;%.0f)".formatted(top, left, bottom, right);
    }
}
