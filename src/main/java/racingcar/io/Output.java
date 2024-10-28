package racingcar.io;

import java.util.List;
import racingcar.car.Car;

public class Output {
    private final static String RESULT_MESSAGE = "\n실행 결과";
    private final static String COLON = " : ";
    private final static String CHAMPION_MESSAGE = "최종 우승자";
    private final static String JOIN_DELIMITER = ", ";
    private final static String MOVE_SYMBOL = "-";

    public void printResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printCar(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + COLON);
            printMoveByOrder(car);
        }
        System.out.println();
    }

    public void printMoveByOrder(Car car) {
        for (int i = 0; i < car.getTotalMove(); i++) {
            System.out.print(MOVE_SYMBOL);
        }
        System.out.println();
    }

    public void printChampion(List<String> champions) {
        System.out.println(CHAMPION_MESSAGE + COLON + String.join(JOIN_DELIMITER, champions));
    }
}
