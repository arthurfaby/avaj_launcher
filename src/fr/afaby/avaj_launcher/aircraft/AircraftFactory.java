package fr.afaby.avaj_launcher.aircraft;

public class AircraftFactory {

    private AircraftFactory() {
    }

    public static Flyable newAircraft(String p_type, String p_name, int p_longitude, int p_latitude, int p_height) {
        Coordinates coordinates = new Coordinates(p_longitude, p_latitude, p_height);

        return switch (p_type.toLowerCase()) {
            case "helicopter" -> new Helicopter(p_name, coordinates);
            case "baloon" -> new Baloon(p_name, coordinates);
            case "jetplane" -> new JetPlane(p_name, coordinates);
            default -> null;
        };
    }
}
