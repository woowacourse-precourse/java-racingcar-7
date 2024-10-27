package racingcar.view;

import racingcar.vo.Car;

import java.util.Set;

public class OutputView {

    private final static String RESULT_MESSAGE = "실행 결과";
    private final static String COLON = " : ";
    private final static String POSITION = "-";

    public void printResultMessage() {
        printGameRoundEnd();
        System.out.println(RESULT_MESSAGE);
    }

    public void printCarsPosition(Set<Car> cars) {
        cars.forEach(car -> {
            System.out.println(car.getName() + COLON + POSITION.repeat(car.getPosition()));
        });
        printGameRoundEnd();
    }

    private void printGameRoundEnd() {
        System.out.println();
    }

}
