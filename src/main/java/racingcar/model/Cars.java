package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void race() {
        for (Car car : cars) {
            car.race();
        }
    }

    public List<String> getCarsInformation() {
        List<String> carsInformation = new ArrayList<>();
        for (Car car : cars) {
            carsInformation.add(car.getInformation());
        }
        return carsInformation;
    }

    public List<String> determineWinners() {
        List<String> winners = new ArrayList<>();
        int maxStatus = 0;

        for (Car car : cars) {
            if (maxStatus < car.getStatus()) {
                maxStatus = car.getStatus();
            }
        }

        for (Car car : cars) {
            if (car.getStatus() == maxStatus) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
