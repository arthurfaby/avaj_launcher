package fr.afaby.avaj.aircraft;

import fr.afaby.avaj.weather.WeatherTower;

/**
 * Flyable class
 */
public abstract class Flyable {

    /**
     * Weather tower to register the aircraft
     */
    protected WeatherTower weatherTower;

    /**
     * Constructor.
     */
    protected Flyable() {}

    /**
     * Update the aircraft coordinates according to the weather
     */
    public abstract void updateConditions();

    /**
     * Register the weather tower
     * @param p_tower Weather tower
     */
    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
    }

    /**
     * Get the prefix for the aircraft
     * @return Prefix
     */
    public abstract String getPrefix();
}
