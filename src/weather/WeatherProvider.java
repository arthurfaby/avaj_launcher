package weather;

import coordinates.Coordinates;

public class WeatherProvider {

    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int weatherIndex = getHashCoordinates(coordinates);
        return weather[weatherIndex];
    }

    private static int getHashCoordinates(Coordinates coordinates) {
        return (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % 4;
    }

}
