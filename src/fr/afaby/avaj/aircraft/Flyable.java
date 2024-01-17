package fr.afaby.avaj.aircraft;

import fr.afaby.avaj.weather.WeatherTower;

/**
 * Flyable class
 */
public abstract class Flyable {

    protected WeatherTower weatherTower;

    public abstract void updateConditions();

    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
    }

    public abstract String getPrefix();
}
