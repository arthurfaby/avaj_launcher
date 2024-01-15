package launcher;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import aircraft.AircraftFactory;
import aircraft.Flyable;
import weather.WeatherTower;

public class Main {

    public static String[] lines;

    public static void main(String[] args) {

        // Flyable b1 = AircraftFactory.newAircraft("Baloon", "B1", 2, 3, 20);
        // Flyable b2 = AircraftFactory.newAircraft("Baloon", "B2", 1, 8, 66);
        // Flyable j1 = AircraftFactory.newAircraft("JetPlane", "J1", 23, 44, 32);
        // Flyable h1 = AircraftFactory.newAircraft("Helicopter", "H1", 654, 33, 20);
        // Flyable h2 = AircraftFactory.newAircraft("Helicopter", "H2", 22, 33, 44);
        // Flyable h3 = AircraftFactory.newAircraft("Helicopter", "H3", 98, 68, 99);
        // Flyable b3 = AircraftFactory.newAircraft("Baloon", "B3", 102, 22, 34);
        // Flyable j2 = AircraftFactory.newAircraft("JetPlane", "J2", 11, 99, 768);
        // Flyable h4 = AircraftFactory.newAircraft("Helicopter", "H4", 223, 23, 54);

        // WeatherTower weatherTower = new WeatherTower();
        // weatherTower.register(b1);
        // weatherTower.register(b2);
        // weatherTower.register(j1);
        // weatherTower.register(h1);
        // weatherTower.register(h2);
        // weatherTower.register(h3);
        // weatherTower.register(b3);
        // weatherTower.register(j2);
        // weatherTower.register(h4);

        // b1.registerTower(weatherTower);
        // b2.registerTower(weatherTower);
        // j1.registerTower(weatherTower);
        // h1.registerTower(weatherTower);
        // h2.registerTower(weatherTower);
        // h3.registerTower(weatherTower);
        // b3.registerTower(weatherTower);
        // j2.registerTower(weatherTower);
        // h4.registerTower(weatherTower);

        // int simulations = 25;
        // while (simulations-- > 0) {
        // weatherTower.changeWeather();
        // }

        initSimulation(args);
    }

    public static boolean initSimulation(String[] args) {
        if (!checkArgs(args)) {
            return false;
        }
        if (!checkScenarioFileExists(args[0])) {
            return false;
        }
        if (!parseFile(args[0])) {
            return false;
        }
        return true;
    }

    private static boolean checkArgs(String[] args) {
        if (args.length != 1) {
            System.err.println("[ERROR] Usage: java -cp src launcher.Main [scenario file]");
            return false;
        }
        return true;
    }

    private static boolean checkScenarioFileExists(String scenarioFileName) {
        File scenarioFile = new File(scenarioFileName);
        if (!scenarioFile.exists()) {
            System.err.println("[ERROR] Scenario file does not exist");
            return false;
        }
        return true;
    }

    private static boolean parseFile(String scenarioFileName) {
        File scenarioFile = new File(scenarioFileName);
        if (!scenarioFile.canRead()) {
            System.err.println("[ERROR] Scenario file is not readable");
            return false;
        }

        // Read file and stock each line in a list
        try {
            InputStream inputStream = new FileInputStream(scenarioFile);
            byte[] buffer = new byte[(int) scenarioFile.length()];
            inputStream.read(buffer);
            String fileContent = new String(buffer);
            lines = fileContent.split("\n");
        } catch (Exception e) {
            System.err.println("[ERROR] Error while reading scenario file");
            return false;
        }
        return true;
    }
}
