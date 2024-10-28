package racingcar.service;

import static racingcar.constants.GameConstants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class RaceManager {
    private final List<Car> cars;
    private final int totalTimes;

    public RaceManager(String[] names, int totalTimes) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        this.totalTimes = totalTimes;
    }

    public void startEachStep() {
        moveCars();
    }

    private void moveCars() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
            if (car.isMoved(randomNumber)) {
                car.move();
            }
        }
    }

    public List<String> getWinners() {
        int maxDistance = cars.stream().mapToInt(Car::getDistance).max().orElse(0);
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTotalTimes() {
        return totalTimes;
    }
}
