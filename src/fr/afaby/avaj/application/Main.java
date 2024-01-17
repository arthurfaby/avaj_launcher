package fr.afaby.avaj.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import fr.afaby.avaj.aircraft.Simulation;

public class Main {

    /**
     * List of lines from scenario file
     */
    public static String[] lines;

    /**
     * Main function
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            initSimulation(args);
            Simulation.launchSimulation();
        } catch (Exception e) {
            System.out.println("\u001B[31m[ERROR] \u001B[0m" + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Initialize simulation
     * @param args command line arguments
     */
    public static void initSimulation(String[] args) throws Exception {
        if (!checkArgs(args)) {
            throw new Exception("Invalid arguments.\nUsage: java -cp src fr.afaby.avaj.application.Main [file]");
        }
        if (!checkScenarioFileExists(args[0])) {
            throw new Exception("Scenario file does not exist");
        }
        if (!parseFile(args[0])) {
            throw new Exception("Error while parsing scenario file");
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
     * Check if scenario file exists
     * @param scenarioFileName  scenario file name
     * @return true if scenario file exists, false otherwise
     */
    private static boolean checkScenarioFileExists(String scenarioFileName) {
        File scenarioFile = new File(scenarioFileName);
        return scenarioFile.exists();
    }

    /**
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
