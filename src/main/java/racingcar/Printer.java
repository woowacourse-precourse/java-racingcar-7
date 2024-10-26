package racingcar;

public class Printer {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printRaceResult(Car car) {
        String result = car.getName() + " : ";
        for (int i = 0; i < car.getMoveCount(); i++) {
            result += '-';
        }
        System.out.println(result);
    }

//    public static void printRaceWinner() {}
}