package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racingcar.model.Car;

public class RacingService {

    public void race(List<Car> cars) {
        for (Car car : cars) {
            if (shouldMove()) {
                car.move();
            }
        }
    }

    public boolean shouldMove() {
        return Randoms.pickNumberInRange(0, 9) > 3;
    }

    public void printCarStatus(List<Car> cars) {
        for(Car car : cars) {
            System.out.println(car.getStatus());
        }
    }

    public Car compareCarStatus(List<Car> cars) {
        Car winner = cars.get(0);
        for (Car car : cars) {
            if (car.getPosition() > winner.getPosition()) {
                winner = car;
            }
        }
        return winner;
    }
}
