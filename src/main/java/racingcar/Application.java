package racingcar;

import java.util.List;

import static racingcar.WinnerCalculator.calculateWinners;

public class Application {
    private static final String POSITION_STRING_FORMAT = "-";
    private static final String CUSTOM_DELIMITER = ", ";
    private static final String CAR_STRING_FORMAT = " : ";

    public static void main(String[] args) {
        String carName = Input.getCarName();
        int raceTime = Input.getRaceTime();

        CarNames carNames = new CarNames(carName);
        Cars cars = new Cars(carNames.createCars());

        System.out.println("실행 결과");
        List<Car> racingCars = race(raceTime, cars);

        System.out.println("최종 우승자 : " + String.join(CUSTOM_DELIMITER, calculateWinners(racingCars)));
    }

    public static List<Car> race(int raceTime, Cars cars) {
        List<Car> movingCars = null;
        for (int i = 0; i < raceTime; i++) {
            movingCars = moveCars(cars);
        }

        return movingCars;
    }

    private static List<Car> moveCars(Cars cars) {
        List<Car> racingCars = cars.moveCars();
        for (Car racingCar : racingCars) {
            System.out.println(racingCar.toCustomFormatString(CAR_STRING_FORMAT, POSITION_STRING_FORMAT));
        }
        System.out.println();

        return racingCars;
    }
}
