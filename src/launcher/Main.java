package launcher;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import aircraft.AircraftFactory;
import aircraft.Flyable;
import weather.WeatherTower;

public class Main {

    /**
     * @public
     * List of lines from scenario file
     */
    public static String[] lines;




    /**
     * @public
     * Main function
     * @param args command line arguments
     */
    public static void main(String[] args) {

//         Flyable b1 = AircraftFactory.newAircraft("Baloon", "B1", 2, 3, 20);
//         Flyable b2 = AircraftFactory.newAircraft("Baloon", "B2", 1, 8, 66);
//         Flyable j1 = AircraftFactory.newAircraft("JetPlane", "J1", 23, 44, 32);
//         Flyable h1 = AircraftFactory.newAircraft("Helicopter", "H1", 654, 33, 20);
//         Flyable h2 = AircraftFactory.newAircraft("Helicopter", "H2", 22, 33, 44);
//         Flyable h3 = AircraftFactory.newAircraft("Helicopter", "H3", 98, 68, 99);
//         Flyable b3 = AircraftFactory.newAircraft("Baloon", "B3", 102, 22, 34);
//         Flyable j2 = AircraftFactory.newAircraft("JetPlane", "J2", 11, 99, 768);
//         Flyable h4 = AircraftFactory.newAircraft("Helicopter", "H4", 223, 23, 54);

//         WeatherTower weatherTower = new WeatherTower();
//         weatherTower.register(b1);
//         weatherTower.register(b2);
//         weatherTower.register(j1);
//         weatherTower.register(h1);
//         weatherTower.register(h2);
//         weatherTower.register(h3);
//         weatherTower.register(b3);
//         weatherTower.register(j2);
//         weatherTower.register(h4);

//         b1.registerTower(weatherTower);
//         b2.registerTower(weatherTower);
//         j1.registerTower(weatherTower);
//         h1.registerTower(weatherTower);
//         h2.registerTower(weatherTower);
//         h3.registerTower(weatherTower);
//         b3.registerTower(weatherTower);
//         j2.registerTower(weatherTower);
//         h4.registerTower(weatherTower);

//         int simulations = 25;
//         while (simulations-- > 0) {
//         weatherTower.changeWeather();
//         }

        try {
            initSimulation(args);
            launchSimulation();
        } catch (Exception e) {
            System.err.println("\u001B[31m[ERROR] \u001B[0m" + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * @public
     * Launch simulation
     */
    public static void launchSimulation() {
        WeatherTower weatherTower = new WeatherTower();
        int simulations = Integer.parseInt(lines[0].split(" ")[0]);
        int lineIndex = 1;
        while (lineIndex < lines.length) {
            String[] aircraftData = lines[lineIndex].split(" ");
            Flyable aircraft = AircraftFactory.newAircraft(aircraftData[0], aircraftData[1], Integer.parseInt(aircraftData[2]), Integer.parseInt(aircraftData[3]), Integer.parseInt(aircraftData[4]));
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
     * @public
     * Initialize simulation
     * @param args command line arguments
     */
    public static void initSimulation(String[] args) throws Exception {
        if (!checkArgs(args)) {
            throw new Exception("Invalid arguments.\nUsage: java -cp src launcher.Main [scenario file]");
        }
        if (!checkScenarioFileExists(args[0])) {
            throw new Exception("Scenario file does not exist");
        }
        if (!parseFile(args[0])) {
            throw new Exception("Error while parsing scenario file");
        }
    }

    /**
     * @private
     * Check if arguments are valid
     * @param args command line arguments
     * @return true if arguments are valid, false otherwise
     */
    private static boolean checkArgs(String[] args) {
        return args.length == 1;
    }

    /**
     * @private
     * Check if scenario file exists
     * @param scenarioFileName  scenario file name
     * @return true if scenario file exists, false otherwise
     */
    private static boolean checkScenarioFileExists(String scenarioFileName) {
        File scenarioFile = new File(scenarioFileName);
        return scenarioFile.exists();
    }

    /**
     * @private
     * Parse scenario file
     * @param scenarioFileName scenario file name
     * @return true if scenario file has been parsed, false otherwise
     */
    private static boolean parseFile(String scenarioFileName) {
        File scenarioFile = new File(scenarioFileName);
        if (!scenarioFile.canRead()) {
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
            return false;
        }
        return true;
    }
}
