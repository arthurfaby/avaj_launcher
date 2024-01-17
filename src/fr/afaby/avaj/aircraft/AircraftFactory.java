package fr.afaby.avaj.aircraft;

public class AircraftFactory {

    public static int nbOfAircraft = 0;

    private AircraftFactory() {
    }

    public static Flyable newAircraft(String p_type, String p_name, Coordinates coordinates) {
        Flyable flyable = switch (p_type.toLowerCase()) {
            case "helicopter" -> new Helicopter(AircraftFactory.nbOfAircraft, p_name, coordinates);
            case "baloon" -> new Baloon(AircraftFactory.nbOfAircraft ,p_name, coordinates);
            case "jetplane" -> new JetPlane(AircraftFactory.nbOfAircraft, p_name, coordinates);
            default -> null;
        };
        //TODO: assert flyable != null
        AircraftFactory.nbOfAircraft++;
        return flyable;
    }
}
