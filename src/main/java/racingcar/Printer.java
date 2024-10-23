package racingcar;

public abstract class Printer {

    public static void print(SystemMessage message) {
        print(message.getMessage());
    }
    public static void print(Car car) {
        print(car.toString());
    }
    public static void newLine() {
        print("");
    }

    public static void print(SystemMessage message, String winner) {
        print(message.getMessage() + winner);
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
