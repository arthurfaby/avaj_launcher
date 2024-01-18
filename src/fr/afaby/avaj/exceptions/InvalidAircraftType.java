package fr.afaby.avaj.exceptions;

/**
 * Invalid aircraft type exception.
 */
public class InvalidAircraftType extends Exception {

    /**
     * Constructor.
     * @param message Message of the exception.
     */
    public InvalidAircraftType(String message) {
        super(message);
    }
}
