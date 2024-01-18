package fr.afaby.avaj.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * OutputLog class to log the output.
 */
public class OutputLog {

    /**
     * Singleton instance.
     */
    private static OutputLog instance = null;

    /**
     * Writer to write in the simulation.txt file.
     */
    private BufferedWriter writer;

    /**
     * Constructor.
     */
    private OutputLog() {
        try {
            this.writer = new BufferedWriter(new FileWriter("simulation.txt"));
            this.writer.write("");
        } catch (IOException e) {
            System.out.println("\u001B[31m[ERROR] \u001B[0m" + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Get the singleton instance.
     * @return OutputLog instance
     */
    public static synchronized OutputLog getInstance() {
        if (instance == null) {
            instance = new OutputLog();
        }
        return instance;
    }

    /**
     * Log the message info the simulation.txt file.
     * @param message Message to log.
     */
    public void log(String message) {
        try {
            this.writer.append(message).append("\n");
        } catch (IOException e) {
            System.out.println("\u001B[31m[ERROR] \u001B[0m" + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Close the writer.
     */
    public void close() {
        try {
            this.writer.close();
        } catch (IOException e) {
            System.out.println("\u001B[31m[ERROR] \u001B[0m" + e.getMessage());
            System.exit(1);
        }
    }
}
