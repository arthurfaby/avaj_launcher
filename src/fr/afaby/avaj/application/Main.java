package fr.afaby.avaj.application;

import java.io.*;

import fr.afaby.avaj.aircraft.Simulation;
import fr.afaby.avaj.exceptions.CantReadFile;
import fr.afaby.avaj.exceptions.FileIsEmpty;
import fr.afaby.avaj.exceptions.IncorrectLine;
import fr.afaby.avaj.file.OutputLog;

/**
 * Main class to check and parse the input file.
 */
public class Main {

    /**
     * List of lines from scenario file
     */
    public static String[] lines;

    /**
     * Constructor.
     */
    private Main() {}

    /**
     * Main function
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            checkBeforeSimulator(args);
            Simulation.launchSimulation();
            OutputLog.getInstance().close();
        } catch (Exception e) {
            System.out.println("\u001B[31m[ERROR] \u001B[0m" + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Do checks before simulation
     * @param args command line arguments
     * @throws Exception if arguments are invalid or scenario file does not exist
     */
    public static void checkBeforeSimulator(String[] args) throws Exception {
        if (!checkArgs(args)) {
            throw new Exception("Invalid arguments.\nUsage: java -cp src fr.afaby.avaj.application.Main [file]");
        }
        if (!checkScenarioFileExists(args[0])) {
            throw new Exception("Scenario file does not exist");
        }
        parseFile(args[0]);
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
     * @throws CantReadFile if file can't be read
     * @throws FileIsEmpty if file is empty
     * @throws IncorrectLine if a line is invalid
     * @throws IOException if an I/O error occurs
     */
    private static void parseFile(String scenarioFileName) throws CantReadFile, IOException, FileIsEmpty, IncorrectLine {
        File scenarioFile = new File(scenarioFileName);
        if (!scenarioFile.exists()) {
            throw new CantReadFile("File does not exist");
        } else if (!scenarioFile.canRead()) {
            throw new CantReadFile("Can't read file");
        }

        // Read file and stock each line in a list
        try (FileInputStream inputStream = new FileInputStream(scenarioFile)) {
            byte[] buffer = new byte[(int) scenarioFile.length()];
            if (inputStream.read(buffer) == -1) {
                throw new FileIsEmpty("File is empty");
            }
            String fileContent = new String(buffer);
            lines = fileContent.split("\n");
            checkLines(lines);
        }
    }

    /**
     * Check if each line is valid
     * @param lines list of lines
     * @throws IncorrectLine if a line is invalid
     */
    private static void checkLines(String[] lines) throws IncorrectLine {
        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].trim();
            if (i == 0) {
                if (!lines[i].matches("\\d+")) {
                    throw new IncorrectLine("First line should be a positive integer");
                }
            } else {
                if (!lines[i].matches("[a-zA-Z]+ [a-zA-Z0-9]+ \\d+ \\d+ \\d+")) {
                    throw new IncorrectLine("Invalid line(" + (i + 1) + "): " + lines[i]);
                }
            }
        }
    }
}
