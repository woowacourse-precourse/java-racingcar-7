package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class PlayersCars {
    private List<Car> playersCars;

    public PlayersCars(List<String> userNames) {
        for (String each : userNames) {
            this.playersCars.add(new Car(each));
        }
    }

    public void moveSequence(NumberGenerator numberGenerator) {
        for (Car each : playersCars) {
            each.moveCar(numberGenerator.generateNumber());
        }
    }

    public List<String> findMaximumScoreCars() {
        int maxScore = playersCars.stream()
                .mapToInt(car -> car.getScore().getScore())
                .max()
                .orElse(-1);

        return playersCars.stream()
                .filter(car -> car.getScore().getScore() == maxScore)
                .map(Car::getUserName)
                .toList();
    }
}
