package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {
    private static final Configuration CONFIG = Configuration.getInstance();
    private static final BigDecimal CONST = CONFIG.getConstVariable();
    private static final BigDecimal X_CONST = CONFIG.getxConst();
    private static final BigDecimal Y_CONST = CONFIG.getyConst();

    public static Rectangle toRectangle(PixelCoordinates leftPixelCoordinates, PixelCoordinates rightPixelCoordinates) {
        return new Rectangle(leftPixelCoordinates.getX(),
                leftPixelCoordinates.getX(),
                rightPixelCoordinates.getY() - leftPixelCoordinates.getY(),
                rightPixelCoordinates.getX() - leftPixelCoordinates.getX());
    }

    public static Rectangle toRectangle(GeoCoordinates leftGeoCoordinates, GeoCoordinates rightGeoCoordinates) {
        PixelCoordinates leftPixelCoordinates = toPixelCoordinates(leftGeoCoordinates);
        PixelCoordinates rightPixelCoordinates = toPixelCoordinates(rightGeoCoordinates);
        return toRectangle(leftPixelCoordinates, rightPixelCoordinates);
    }

    private static PixelCoordinates toPixelCoordinates(GeoCoordinates coordinates) {
        int x = BigDecimal.valueOf(coordinates.getX())
                .subtract(X_CONST)
                .divide(CONST, RoundingMode.CEILING)
                .intValue();

        int y = BigDecimal.valueOf(coordinates.getY())
                .subtract(Y_CONST)
                .divide(CONST, RoundingMode.CEILING)
                .intValue();

        return new PixelCoordinates(x, y);
    }
}
