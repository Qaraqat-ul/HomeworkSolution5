// Flyweight Pattern 
import java.util.HashMap;
import java.util.Map;

interface Marker {
    void display(int x, int y);
}

class ConcreteMarker implements Marker {
    private String type;

    public ConcreteMarker(String type) {
        this.type = type;
    }

    public void display(int x, int y) {
        System.out.println(type + " marker at (" + x + "," + y + ")");
    }
}

class MarkerFactory {
    private static Map<String, Marker> markers = new HashMap<>();

    public static Marker getMarker(String type) {
        if (!markers.containsKey(type)) {
            markers.put(type, new ConcreteMarker(type));
        }
        return markers.get(type);
    }

    public static int getMarkerCount() {
        return markers.size();
    }
}

public class Main {
    public static void main(String[] args) {
        Marker m1 = MarkerFactory.getMarker("Hospital");
        Marker m2 = MarkerFactory.getMarker("Restaurant");
        Marker m3 = MarkerFactory.getMarker("Hospital");

        m1.display(10, 20);
        m2.display(15, 25);
        m3.display(30, 40);

        System.out.println("Unique markers: " + MarkerFactory.getMarkerCount());
    }
}
