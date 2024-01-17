package fr.afaby.avaj_launcher.weather;

import fr.afaby.avaj_launcher.aircraft.Coordinates;

public class WeatherProvider {

    private static final String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };

    private WeatherProvider() { }

    public static String getCurrentWeather(Coordinates coordinates) {
        int weatherIndex = getHashCoordinates(coordinates);
        return weather[weatherIndex];
    }

    private static int getHashCoordinates(Coordinates coordinates) {
        return (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % 4;
    }

}
