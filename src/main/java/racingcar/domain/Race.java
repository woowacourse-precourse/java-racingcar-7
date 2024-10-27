package racingcar.domain;

import racingcar.util.RandomMovementGenerator;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars = new ArrayList<>();

    public Race(String[] players) {
        for (String player : players) {
            cars.add(new Car(player, ""));
        }
    }

    public String runRound() {
        StringBuilder result = new StringBuilder();
        cars.forEach(car -> {
            car.updateMovement(RandomMovementGenerator.create());
            result.append(car).append("\n");
        });
        return result.toString();
    }
}
