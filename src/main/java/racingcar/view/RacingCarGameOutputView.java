package racingcar.view;

import racingcar.model.Cars;

public class RacingCarGameOutputView {

    private RacingCarGameOutputView() {
    }

    public static void printExecutionResultHeader() {
        System.out.println();
        System.out.println("실행결과");
    }

    public static void printCarPositions(Cars cars) {
        cars.getCars().forEach(car -> {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        });
        System.out.println();
    }

}