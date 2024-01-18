package fr.afaby.avaj.weather;

import fr.afaby.avaj.aircraft.Coordinates;

/**
 * WeatherProvider class to get the weather.
 */
public final class WeatherProvider {

    /**
     * Weather array.
     */
    private static final String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };

    /**
     * Singleton instance.
     */
    private static WeatherProvider instance = null;

    /**
     * Private constructor.
     */
    private WeatherProvider() {}

    /**
     * Get the singleton instance.
     * @return WeatherProvider instance
     */
    public static synchronized WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    /**
     * Get the current weather.
     * @param p_coordinates Coordinates
     * @return Current weather
     */
    public String getCurrentWeather(Coordinates p_coordinates) {
        int weatherIndex = getHashCoordinates(p_coordinates);
        return weather[weatherIndex];
    }

    /**
     * Get the index to use in the array of weather.
     * @param coordinates Coordinates
     * @return index of the weather array
     */
    private int getHashCoordinates(Coordinates coordinates) {
        return (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % weather.length;
    }

}
