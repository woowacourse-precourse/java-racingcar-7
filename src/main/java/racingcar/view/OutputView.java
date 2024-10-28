package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    public static final String FORWARD_MOVEMENT = "-";

    public static void printGameResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printWinnerMessage() {
        System.out.print("최종 우승자 : ");
    }

    public static void printRaceProgress(List<Car> cars) {

        for (Car car : cars) {
            printCarName(car);
            printMovingRoad(car.getMoveCount());
        }
    }

    public static void printWinner(String winners) {

        printWinnerMessage();
        System.out.println(winners);
    }

    private static void printCarName(Car car) {

        System.out.print(car.getCarName() + " : ");
    }

    private static void printMovingRoad(int moveCount) {

        for (int i = 0; i < moveCount; i++) {
            System.out.print(FORWARD_MOVEMENT);
        }
        System.out.println();
    }



}
