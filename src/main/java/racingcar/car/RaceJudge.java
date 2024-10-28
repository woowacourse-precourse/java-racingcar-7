package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class RaceJudge {

    private final List<Car> cars;

    private RaceJudge(List<Car> cars) {
        this.cars = cars;
    }

    public static RaceJudge of(List<Car> cars) {
        return new RaceJudge(cars);
    }

    public List<String> findFinalWinner() {
        List<String> winners = new ArrayList<>();

        int maxMileage = findMaxMileage();

        for (Car car : cars) {
            if (car.matchesMaxMileage(maxMileage)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int findMaxMileage() {
        return cars.stream()
                .mapToInt(Car::getMileage)
                .max()
                .orElse(0);
    }

}
