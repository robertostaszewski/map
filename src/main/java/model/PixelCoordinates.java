package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="PixelCoordinates")
public class PixelCoordinates {

    @XmlElement
    private Integer x;
    @XmlElement
    private Integer y;

    public PixelCoordinates() {
    }

    public PixelCoordinates(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
}
