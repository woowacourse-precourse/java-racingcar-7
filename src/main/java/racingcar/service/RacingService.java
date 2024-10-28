package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class RacingService {

    public void race(List<Car> cars) {
        for (Car car : cars) {
            if (shouldMove()) {
                car.move();
            }
        }
        printCarStatus(cars);
    }

    public boolean shouldMove() {
        return Randoms.pickNumberInRange(0, 9) > 3;
    }

    public void printCarStatus(List<Car> cars) {
        for (Car car : cars) {
            car.pritntStatus();
        }
        System.out.println();
    }

    public List<Car> findWinners(List<Car> cars) {
        Car maxPositionCar = findMaxPositionCar(cars);

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isAtSamePosition(maxPositionCar)) {
                winners.add(car);
            }
        }
        return winners;
    }

    private Car findMaxPositionCar(List<Car> cars) {
        Car maxPositionCar = cars.get(0);

        for (Car car : cars) {
            if (car.isAheadOf(maxPositionCar)) {
                maxPositionCar = car;
            }
        }
        return maxPositionCar;
    }
}
