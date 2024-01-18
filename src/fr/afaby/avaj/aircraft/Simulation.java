package fr.afaby.avaj.aircraft;

import fr.afaby.avaj.application.Main;
import fr.afaby.avaj.exceptions.InvalidAircraftType;
import fr.afaby.avaj.weather.WeatherTower;

/**
 * Simulation class to launch the simulation.
 */
public class Simulation {

    /**
     * Constructor.
     */
    private Simulation() {}

    /**
     * Launch the simulation.
     * - Create the weather tower
     * - Create the aircrafts
     * - Register the aircrafts to the weather tower
     * - Change the weather for each simulation
     * @throws fr.afaby.avaj.exceptions.InvalidAircraftType Invalid aircraft type
     */
    public static void launchSimulation() throws InvalidAircraftType {
        WeatherTower weatherTower = new WeatherTower();
        int simulations = Integer.parseInt(Main.lines[0].split(" ")[0]);
        int lineIndex = 1;
        while (lineIndex < Main.lines.length) {
            parseLine(weatherTower, lineIndex);
            lineIndex++;
        }
        while (simulations > 0) {
            weatherTower.changeWeather();
            simulations--;
        }
    }

    private static void parseLine(WeatherTower weatherTower, int lineIndex) throws InvalidAircraftType {
        String[] aircraftData = Main.lines[lineIndex].split(" ");
        Coordinates coordinates = new Coordinates(Integer.parseInt(aircraftData[2]), Integer.parseInt(aircraftData[3]), Integer.parseInt(aircraftData[4]));
        Flyable aircraft = AircraftFactory.getInstance().newAircraft(aircraftData[0], aircraftData[1], coordinates);
        aircraft.registerTower(weatherTower);
        weatherTower.register(aircraft);
    }
}
