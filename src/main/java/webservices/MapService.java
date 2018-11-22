package webservices;

import model.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService()
public class MapService {

    private MapEngine mapEngine = new MapEngine();

    @WebMethod(operationName = "zoomPixels")
    public String zoomPixels(@WebParam(name = "leftCoordinates") PixelCoordinates leftCoordinates,
                             @WebParam(name = "rightCoordinates") PixelCoordinates rightCoordinates) {
        Rectangle rectangle = Calculator.toRectangle(leftCoordinates, rightCoordinates);
        return getEncodedMapSubimage(rectangle);
    }

    @WebMethod(operationName = "zoomGeo")
    public String zoomGeo(@WebParam(name = "leftCoordinates") GeoCoordinates leftCoordinates,
                          @WebParam(name = "rightCoordinates") GeoCoordinates rightCoordinates) {
        Rectangle rectangle = Calculator.toRectangle(leftCoordinates, rightCoordinates);
        return getEncodedMapSubimage(rectangle);
    }

    @WebMethod(operationName = "fullMap")
    public String fullMap() {
        return mapEngine.getEncodedFullMap();
    }

    private String getEncodedMapSubimage(Rectangle rectangle) {
        return mapEngine.getEncodedMapSubimage(rectangle);
    }

    public static void main(String[] argv) {
        Object implementor = new MapService();
        String address = "http://localhost:9000/MapService";
        Endpoint.publish(address, implementor);
    }
}
