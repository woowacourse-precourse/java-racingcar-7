package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarsGroup {

    private List<Car> cars = new ArrayList<>();

    public RacingCarsGroup() {
    }

    public RacingCarsGroup(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getFinalWinners(List<Car> cars) {
        List<Car> finalWinners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == getMaxPositionIdx(cars)) {
                finalWinners.add(car);
            }
        }
        return finalWinners;
    }

    private int getMaxPositionIdx(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

}
