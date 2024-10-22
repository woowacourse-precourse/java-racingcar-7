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
        for(Car car : cars) {
            System.out.println(car.getStatus());
        }
    }

    public List<Car> findWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int findMaxPosition(List<Car> cars) {
        int maxPosition = cars.get(0).getPosition();

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
}
