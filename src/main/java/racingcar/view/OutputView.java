package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    private static final String RESULT_MESSAE = "실행 결과";
    private static final String WINNER_ANNOUNCEMENT_MESSAGE = "최종 우승자 : ";

    public static void printExecutionResult() {
        System.out.println();
        System.out.println(RESULT_MESSAE);
    }

    public static void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " +  car.getPositionSymbols());
        }
        System.out.println();
    }

    public static void printWinners(List<String> Winners) {

    }
}
