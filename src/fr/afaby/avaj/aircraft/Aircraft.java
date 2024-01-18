package fr.afaby.avaj.aircraft;

import fr.afaby.avaj.file.OutputLog;

/**
 * Aircraft class. This class extends Flyable class.
 * @see Flyable
 */
public class Aircraft extends Flyable {

    /**
     * Message for snow weather.
     */
    protected String snowMessage = "Snow.";

    /**
     * Message for rain weather.
     */
    protected String rainMessage = "Rain.";

    /**
     * Message for sun weather.
     */
    protected String sunMessage = "Sun.";

    /**
     * Message for fog weather.
     */
    protected String fogMessage = "Fog.";

    /**
     * Aircraft id.
     */
    protected long id;

    /**
     * Aircraft name.
     */
    protected String name;

    /**
     * Aircraft coordinates.
     */
    protected Coordinates coordinates;

    /**
     * Aircraft type.
     */
    protected String type;

    /**
     * Constructor.
     * @param p_id             Aircraft id.
     * @param p_name           Aircraft name.
     * @param p_coordinate     Aircraft coordinates.
     */
    protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinate;
    }

    /**
     * Update conditions method which is override by children.
     */
    @Override
    public void updateConditions() {
        throw new UnsupportedOperationException("Should not be called.");
    }

    /**
     * Get prefix of the aircraft.
     * Format: TYPE#NAME(ID)
     * @return Prefix of the aircraft
     */
    public String getPrefix() {
        return this.type + "#" + this.name + "(" + this.id + ")";
    }

    /**
     * Check the height of the aircraft. If height is less or equal to 0, the aircraft is landing.
     */
    protected void checkHeight() {
        if (this.coordinates.getHeight() <= 0) {
            OutputLog.getInstance().log(this.getPrefix() + " landing.");
            this.weatherTower.unregister(this);
        }
    }
}
