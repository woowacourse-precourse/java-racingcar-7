package racingcar.util;

import racingcar.game.Car;

public abstract class Printer {

    public static void print(SystemMessage message) {
        printMessage(message.getMessage());
    }
    public static void print(Car car) {
        printMessage(car.toString());
    }
    public static void newLine() {
        printMessage("");
    }

    public static void print(SystemMessage message, String winner) {
        printMessage(message.getMessage() + winner);
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
