package racingcar;

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

    public void determineWinners() {
        int maxMileage = Car.findMaxMileage(cars);

        for (Car car : cars) {
            if (car.hasMaxMileage(maxMileage)) {
                car.updateWin();
            }
        }
    }

    public List<String> findFinalWinner() {
        List<String> winners = new ArrayList<>();

        int maxMileage = Car.findMaxMileage(cars);

        for (Car car : cars) {
            if (car.hasMaxMileage(maxMileage)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

}
