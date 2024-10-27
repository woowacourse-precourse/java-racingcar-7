package racingcar;

import static racingcar.RacingConstants.MIN_NUMBER_TO_MOVE;

import java.util.List;

public class Move {
    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    public Move(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public void tryOnce() {
        for (Car car : cars) {
            int number = numberGenerator.pickOne();
            boolean possible = isPossible(number);
            car.moveForwardIf(possible);
        }
    }

    private boolean isPossible(int number) {
        return number >= MIN_NUMBER_TO_MOVE;
    }
}
