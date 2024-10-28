package racingcar;

import static racingcar.WinnerCalculator.calculateWinners;

public class OutputView {
    private static final String POSITION_STRING_FORMAT = "-";
    private static final String CAR_STRING_FORMAT = " : ";

    private static final String CUSTOM_DELIMITER = ", ";

    private OutputView() {
    }

    public static void printWinners(Cars cars) {
        System.out.println("최종 우승자 : " + String.join(CUSTOM_DELIMITER, calculateWinners(cars)));
    }

    public static void printCars(int raceTime, Cars cars) {
        System.out.println("실행 결과");
        for (int i = 0; i < raceTime; i++) {
            moveCars(cars);
        }
    }

    private static void moveCars(Cars cars) {
        cars.moveCars();
        for (Car racingCar : cars.getCars()) {
            String carName = racingCar.getCarName()
                    .getCarName();
            int currentPosition = racingCar.getCarPosition()
                    .getCurrentPosition();

            System.out.println(carName + CAR_STRING_FORMAT + POSITION_STRING_FORMAT.repeat(currentPosition));
        }
        System.out.println();
    }
}
