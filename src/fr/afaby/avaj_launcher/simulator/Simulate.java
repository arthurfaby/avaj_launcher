package fr.afaby.avaj_launcher.simulator;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import fr.afaby.avaj_launcher.aircraft.AircraftFactory;
import fr.afaby.avaj_launcher.aircraft.Flyable;
import fr.afaby.avaj_launcher.weather.WeatherTower;

public class Simulate {

    /**
     * List of lines from scenario fr.afaby.avaj_launcher.file
     */
    public static String[] lines;





    /**
     * Main function
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            initSimulation(args);
            launchSimulation();
        } catch (Exception e) {
            System.out.println("\u001B[31m[ERROR] \u001B[0m" + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Launch simulation
     */
    public static void launchSimulation() {
        WeatherTower weatherTower = new WeatherTower();
        int simulations = Integer.parseInt(lines[0].split(" ")[0]);
        int lineIndex = 1;
        while (lineIndex < lines.length) {
            String[] aircraftData = lines[lineIndex].split(" ");
            Flyable aircraft = AircraftFactory.newAircraft(aircraftData[0], aircraftData[1], Integer.parseInt(aircraftData[2]), Integer.parseInt(aircraftData[3]), Integer.parseInt(aircraftData[4]));
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

    /**
     * Initialize simulation
     * @param args command line arguments
     */
    public static void initSimulation(String[] args) throws Exception {
        if (!checkArgs(args)) {
            throw new Exception("Invalid arguments.\nUsage: java -cp src fr.afaby.avaj_launcher.launcher.Main [scenario fr.afaby.avaj_launcher.file]");
        }
        if (!checkScenarioFileExists(args[0])) {
            throw new Exception("Scenario fr.afaby.avaj_launcher.file does not exist");
        }
        if (!parseFile(args[0])) {
            throw new Exception("Error while parsing scenario fr.afaby.avaj_launcher.file");
        }
    }

    /**
     * Check if arguments are valid
     * @param args command line arguments
     * @return true if arguments are valid, false otherwise
     */
    private static boolean checkArgs(String[] args) {
        return args.length == 1;
    }

    /**
     * Check if scenario fr.afaby.avaj_launcher.file exists
     * @param scenarioFileName  scenario fr.afaby.avaj_launcher.file name
     * @return true if scenario fr.afaby.avaj_launcher.file exists, false otherwise
     */
    private static boolean checkScenarioFileExists(String scenarioFileName) {
        File scenarioFile = new File(scenarioFileName);
        return scenarioFile.exists();
    }

    /**
     * Parse scenario fr.afaby.avaj_launcher.file
     * @param scenarioFileName scenario fr.afaby.avaj_launcher.file name
     * @return true if scenario fr.afaby.avaj_launcher.file has been parsed, false otherwise
     */
    private static boolean parseFile(String scenarioFileName) {
        File scenarioFile = new File(scenarioFileName);
        if (!scenarioFile.canRead()) {
            return false;
        }

        // Read fr.afaby.avaj_launcher.file and stock each line in a list
        try {
            InputStream inputStream = new FileInputStream(scenarioFile);
            byte[] buffer = new byte[(int) scenarioFile.length()];
            inputStream.read(buffer);
            String fileContent = new String(buffer);
            lines = fileContent.split("\n");
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
