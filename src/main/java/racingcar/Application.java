package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static racingcar.WinnerCalculator.calculateWinners;

public class Application {
    public static void main(String[] args) {
        String carName = Input.getCarName();
        int raceTime = Input.getRaceTime();

        CarNames carNames = new CarNames(carName);
        Cars cars = new Cars(carNames.createCars());

        System.out.println("실행 결과");
        List<Car> racingCars = race(raceTime, cars);

        List<String> winnerNames = calculateWinners(racingCars);
        String winnerRecord = String.join(", ", winnerNames);
        System.out.println("최종 우승자 : " + winnerRecord);
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
            System.out.println(racingCar.toCustomFormatString("-"));
        }
        System.out.println();

        return racingCars;
    }
}
