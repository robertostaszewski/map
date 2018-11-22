package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="GeoCoordinates")
public class GeoCoordinates {

    @XmlElement
    private Double x;
    @XmlElement
    private Double y;

    public GeoCoordinates() {
    }

    public GeoCoordinates(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }
}
