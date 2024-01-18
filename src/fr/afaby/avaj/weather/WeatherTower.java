package fr.afaby.avaj.weather;

import fr.afaby.avaj.aircraft.Coordinates;
import fr.afaby.avaj.tower.Tower;

/**
 * WeatherTower class
 */
public class WeatherTower extends Tower {

    /**
     * Constructor
     */
    public WeatherTower() {}

    /**
     * Get the weather
     * @param coordinates Coordinates
     * @return Weather
     */
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getInstance().getCurrentWeather(coordinates);
    }

    /**
     * Change the weather
     */
    public void changeWeather() {
        this.conditionChanged();
    }
}
