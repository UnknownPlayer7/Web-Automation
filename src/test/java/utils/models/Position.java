package utils.models;

import lombok.Getter;

import java.util.Locale;
import java.util.Objects;

@Getter
public class Position {
    private static final int TOLERANCE = 4;
    private static final String PATTERN = "%%.%df".formatted(TOLERANCE);
    private double longitude;
    private double latitude;
    private String error;

    public Position(String longitude, String latitude) {
        this.longitude = Double.parseDouble(longitude);
        this.latitude = Double.parseDouble(latitude);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Position position)) return false;

        String adjustedLongitude = addTolerance(longitude);
        String adjustedLatitude = addTolerance(latitude);

        String objectAdjustedLongitude = addTolerance(position.longitude);
        String objectAdjustedLatitude = addTolerance(position.latitude);

        return Objects.equals(adjustedLongitude, objectAdjustedLongitude)
                && Objects.equals(adjustedLatitude, objectAdjustedLatitude);
    }

    private String addTolerance(double number) {
        return String.format(Locale.US, PATTERN, number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addTolerance(longitude), addTolerance(latitude));
    }

    @Override
    public String toString() {
        return "Position{" +
                "latitude=" + addTolerance(latitude) +
                ", longitude=" + addTolerance(longitude) +
                '}';
    }
}
