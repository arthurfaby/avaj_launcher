package weather;

import coordinates.Coordinates;
import tower.Tower;

public class WeatherTower extends Tower {

    public WeatherTower() {
    }

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        // TODO implement and document this method
        this.conditionsChanged();
    }
}
