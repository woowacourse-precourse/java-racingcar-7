package racingcar.view;

import racingcar.model.Cars;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String MOVEMENT_SYMBOL = "-";

    public void printResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public void printRaceResult(Cars cars) {
        cars.cars().forEach(car ->
                System.out.println(car.getName() + " : " + MOVEMENT_SYMBOL.repeat(car.getPosition()))
        );
        System.out.println();
    }

    public void printWinner() {

    }
}
