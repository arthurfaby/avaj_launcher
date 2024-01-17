package fr.afaby.avaj.aircraft;

import fr.afaby.avaj.application.Main;
import fr.afaby.avaj.weather.WeatherTower;

public class Simulation {
    public static void launchSimulation() {
        WeatherTower weatherTower = new WeatherTower();
        int simulations = Integer.parseInt(Main.lines[0].split(" ")[0]);
        int lineIndex = 1;
        while (lineIndex < Main.lines.length) {
            String[] aircraftData = Main.lines[lineIndex].split(" ");
            Coordinates coordinates = new Coordinates(Integer.parseInt(aircraftData[2]), Integer.parseInt(aircraftData[3]), Integer.parseInt(aircraftData[4]));
            Flyable aircraft = AircraftFactory.newAircraft(aircraftData[0], aircraftData[1], coordinates);
            assert aircraft != null;
            aircraft.registerTower(weatherTower);
            weatherTower.register(aircraft);
            lineIndex++;
        }
        while (simulations > 0) {
            weatherTower.changeWeather();
            simulations--;
        }
    }
}
