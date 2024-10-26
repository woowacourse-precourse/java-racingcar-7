package racingcar.domain;

import java.util.List;
import racingcar.utils.generator.NumberGenerator;

public class RaceRule {
    private static final int THRESHOLD = 4;
    private final NumberGenerator numberGenerator;

    public RaceRule(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean canMove() {
        return numberGenerator.generate() >= THRESHOLD;
    }

    public List<Car> determineWinners(List<Car> cars) {
        int maxMovement = getMaxMovement(cars);
        return cars.stream()
                .filter(car -> car.getMovement() == maxMovement)
                .toList();
    }

    private int getMaxMovement(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getMovement)
                .max()
                .orElse(0);
    }
}
