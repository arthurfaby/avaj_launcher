package aircraft;

import coordinates.Coordinates;

public class AircraftFactory {

    private AircraftFactory() {
    }

    public static Flyable newAircraft(String p_type, String p_name, int p_longitude, int p_latitude, int p_height) {
        Coordinates coordinates = new Coordinates(p_longitude, p_latitude, p_height);

        switch (p_type.toLowerCase()) {
            case "helicopter":
                return new Helicopter(p_name, coordinates);
            case "baloon":
                return new Baloon(p_name, coordinates);
            case "jetplane":
                return new JetPlane(p_name, coordinates);
            default:
                return null;
        }
    }
}
