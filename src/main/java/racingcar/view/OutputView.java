package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    private static final int SOLO = 1;

    public static void printHead() {
        System.out.println("실행 결과");
    }

    private static void printScore(List<Car> cars) {
        for (Car car : cars) {
        }
        System.out.println();
    }

    public static void printWinners(List<String> carNames ) {
        System.out.println("최종 우승자 :");
        System.out.println(carNames.get(0));
    }

    public static void printException(String message) {
        System.out.println(message);
    }

    private static void printCarScore(Car car) {
        System.out.println(car.getName() + " : ");
        printPosition(car);
        System.out.println();
    }

    private static void printPosition(Car car) {
        for (int i = 0; i < car.getCurrentPosition(); i++) {
            System.out.println("-");
        }
    }

    private static boolean checkSoloWin(List<String> carNames) {
        return carNames.size() == SOLO;
    }
}