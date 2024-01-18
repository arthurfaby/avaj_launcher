package fr.afaby.avaj.exceptions;

/**
 * Invalid aircraft type exception.
 */
public class CantReadFile extends Exception {

        /**
        * Constructor.
        * @param message Message of the exception.
        */
        public CantReadFile(String message) {
            super(message);
        }
}
