package racingcar.model.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = createCars(carNames);
    }

    private static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public List<Car> getCarsReadOnly() {
        return Collections.unmodifiableList(cars);
    }

    public void raceOnce() {
        for (Car car : cars) {
            car.moveConditionally();
        }
    }

    public List<String> determineWinners() {
        int maxDistance = getMaxDistance();
        return getWinnerNames(maxDistance);
    }

    private int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            int distance = car.getCurrentDistance();
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }
        return maxDistance;
    }

    private List<String> getWinnerNames(int maxDistance) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getCurrentDistance() == maxDistance) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }
}
