package racingcar.domain;

import racingcar.util.RandomMovementGenerator;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars = new ArrayList<>();
    private int max;

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
            max = Math.max(max, car.getMovement().length());
        });
        return result.toString();
    }

    public String checkWinner() {
        StringBuilder result = new StringBuilder();
        List<String> winner = cars.stream().filter(car -> car.getMovement().length() == max)
                .map(Car::getName)
                .toList();
        result.append(String.join(", ", winner));
        return result.toString();
    }
}
