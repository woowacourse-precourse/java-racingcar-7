package racingcar.utils;

public class LoggerUtils {
    private LoggerUtils() {} // 인스턴스화 방지

    public static void logInfo(String message) {
        System.out.println("[INFO] " + message);
    }

    public static void logError(String message) {
        System.err.println("[ERROR] " + message);
    }

    public static void logDebug(String message) {
        System.out.println("[DEBUG] " + message);
    }

    public static void logWarn(String message) {
        System.out.println("[WARN] " + message);
    }
}