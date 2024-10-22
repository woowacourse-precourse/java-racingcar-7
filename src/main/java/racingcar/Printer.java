package racingcar;

public abstract class Printer {

    public static void print(SystemMessage message) {
        System.out.println(message.getMessage());
    }
    public static void print(Car car) {
        System.out.println(car.toString());
    }

    public static void newLine() {
        System.out.println();
    }
}
