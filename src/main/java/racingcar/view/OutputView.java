package racingcar.view;

import racingcar.model.Car;

public class OutputView {

    public void printStartMessage() {
        System.out.println("실행 결과");
    }

    public void printCurrentLocationOf(Car car) {
        final String ONE_STEP = "-";
        System.out.println(car.getName() + " : " + ONE_STEP.repeat(car.getCurrentLocation()));
    }

    public void printEndOfOneRace() {
        System.out.println();
    }
}
