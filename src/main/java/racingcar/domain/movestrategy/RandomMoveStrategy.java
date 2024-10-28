package racingcar.domain.movestrategy;

import racingcar.domain.Car;
import racingcar.domain.numbergenerator.NumberGenerator;

public class RandomMoveStrategy implements MoveStrategy {

    private final NumberGenerator numberGenerator;

    public RandomMoveStrategy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public void move(Car car) {
        if (numberGenerator.generate() >= MINIMUM_MOVE_CONDITION) {
            car.move();
        }
    }
}
