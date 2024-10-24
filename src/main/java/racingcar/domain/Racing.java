package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.RandomNumber;

public class Racing {

    private Cars cars;

    public Racing(Cars cars) {
        this.cars = cars;
    }

    public List<Car> startRacing() {
        for (Car car : cars.getCars()) {
            car.move(RandomNumber.generate());
        }
        return cars.getCars();
    }

    public List<Car> findWinner(List<Car> cars) {
        List<Car> winner = new ArrayList<>();
        int maxMovedDistance = findMaxMovedDistance(cars);
        for (Car car : cars) {
            if (car.getMovedDistance() == maxMovedDistance) {
                winner.add(car);
            }
        }
        return winner;
    }

    private int findMaxMovedDistance(List<Car> cars) {
        int maxMovedDistance = 0;
        for (Car car : cars) {
            if (car.getMovedDistance() > maxMovedDistance) {
                maxMovedDistance = car.getMovedDistance();
            }
        }
        return maxMovedDistance;
    }

}
