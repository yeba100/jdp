
// Modern logging interface
interface Logger {
    void log(String level, String message);
}

// Old legacy logger (only has logMessage)
class LegacyLogger {
    public void logMessage(String message) {
        System.out.println("Legacy log: " + message);
    }
}

// Adapter that makes LegacyLogger compatible with Logger
class LegacyLoggerAdapter implements Logger {
    LegacyLogger legacyLogger;

    LegacyLoggerAdapter(LegacyLogger legacyLogger) {
        this.legacyLogger = legacyLogger;
    }

    public void log(String level, String message) {
        legacyLogger.logMessage("[" + level + "] " + message);
    }
}

// Test
public class Adapter {
    public static void main(String[] args) {
        LegacyLogger oldLogger = new LegacyLogger();
        Logger logger = new LegacyLoggerAdapter(oldLogger);

        logger.log("INFO", "App started");
        logger.log("ERROR", "Something went wrong");
    }
}
