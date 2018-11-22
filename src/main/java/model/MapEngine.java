package model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

public class MapEngine {

    private BufferedImage fullMap;

    public String getEncodedMapSubimage(Rectangle rectangle) {
        BufferedImage subimage = getFullMap()
                .getSubimage(rectangle.getX(), rectangle.getY(), rectangle.getHeight(), rectangle.getWidth());
        return encodeToString(subimage);
    }

    public String getEncodedFullMap() {
        return encodeToString(getFullMap());
    }

    private String encodeToString(BufferedImage subimage) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            ImageIO.write(subimage, "png", byteArrayOutputStream);
            return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private BufferedImage getFullMap() {
        if (fullMap == null) {
            initializeMap();
        }
        return fullMap;
    }

    private void initializeMap() {
        try {
            fullMap = ImageIO.read(getClass().getClassLoader().getResourceAsStream(Configuration.getInstance().getMap()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
