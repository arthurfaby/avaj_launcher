package fr.afaby.avaj.aircraft;

import fr.afaby.avaj.exceptions.InvalidAircraftType;

/**
 * Aircraft factory class.
 * Singleton pattern.
 * Should be used to create aircraft.
 */
public class AircraftFactory {

    /**
     * Number of aircraft that was created (future id of aircraft).
     */
    public static long nbOfAircraft = 0;

    /**
     * Singleton instance.
     */
    private static AircraftFactory instance = null;

    /**
     * Constructor.
     */
    private AircraftFactory() {}

    /**
     * Get the singleton instance.
     * If instance is null, create it.
     * @return AircraftFactory instance.
     */
    public static synchronized AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

    /**
     * Create a new aircraft.
     * @param p_type        Aircraft type.
     * @param p_name        Aircraft name.
     * @param coordinates   Aircraft coordinates.
     * @return              The new flyable object.
     * @throws InvalidAircraftType Invalid aircraft type.
     */
    public Flyable newAircraft(String p_type, String p_name, Coordinates coordinates) throws InvalidAircraftType {
        Flyable flyable = switch (p_type.toLowerCase()) {
            case "helicopter" -> new Helicopter(AircraftFactory.nbOfAircraft, p_name, coordinates);
            case "baloon" -> new Baloon(AircraftFactory.nbOfAircraft ,p_name, coordinates);
            case "jetplane" -> new JetPlane(AircraftFactory.nbOfAircraft, p_name, coordinates);
            default -> null;
        };
        //TODO: assert flyable != null
        if (flyable == null) {
            throw new InvalidAircraftType("Invalid aircraft type: " + p_type);
        }
        AircraftFactory.nbOfAircraft++;
        return flyable;
    }
}
