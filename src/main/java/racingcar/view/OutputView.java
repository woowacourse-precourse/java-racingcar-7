package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    private static final String RESULT = "실행 결과";
    private static final String COLON = " : ";
    private static final String LINE = "-";

    public static void printRacingResultMessage(){
        System.out.println(RESULT);
    }

    public static void printRacingCars(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + COLON + LINE.repeat(car.getPosition()));
        }
        System.out.println();
    }
}
