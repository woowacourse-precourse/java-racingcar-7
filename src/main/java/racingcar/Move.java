package racingcar;

import java.util.List;

public class Move {
    private final List<Car> cars;
    private final NumberValidator numberValidator;
    private final NumberGenerator numberGenerator;

    public Move(List<Car> cars, NumberValidator numberValidator, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberValidator = numberValidator;
        this.numberGenerator = numberGenerator;
    }

    public void tryOnce() {
        for (Car car : cars) {
            int randomNumber = numberGenerator.pickOne();
            boolean canMove = numberValidator.isAboveLowerBound(randomNumber);
            car.moveForwardIf(canMove);
        }
    }
}
