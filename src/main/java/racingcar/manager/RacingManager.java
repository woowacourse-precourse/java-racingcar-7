package racingcar.manager;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.car.Car;

import java.util.Set;

public class RacingManager {
    private final static String RESULT_START_MESSAGE = "실행 결과";

    public void racingStart(Set<Car> cars, int attemptNumber) {
        System.out.println(RESULT_START_MESSAGE);

        for (int i = 0; i < attemptNumber; i++) {
            raceOnce(cars);
            printPositionStatus(cars);
        }
    }

    private void printPositionStatus(Set<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    private void raceOnce(Set<Car> cars) {
        for (Car car : cars) {
            moveCar(car);
        }
    }

    private void moveCar(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        car.move(randomNumber);
    }
}
