package file;

import java.io.File;

public class OutputLog {
    private static OutputLog outputLog = new OutputLog();

    private OutputLog() {
    }

    public static OutputLog getOutputLog() {
        return outputLog;
    }

    public static void log(String message) {
        System.out.println(message);
    }
}
