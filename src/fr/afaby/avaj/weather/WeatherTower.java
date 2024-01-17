package fr.afaby.avaj.weather;

import fr.afaby.avaj.aircraft.Coordinates;
import fr.afaby.avaj.tower.Tower;

public class WeatherTower extends Tower {

    public WeatherTower() {
    }

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        // TODO implement and document this method
        this.conditionsChanged();
    }
}
