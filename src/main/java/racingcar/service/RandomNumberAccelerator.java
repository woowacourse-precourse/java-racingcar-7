package racingcar.service;

import racingcar.domain.car.Car;
import racingcar.util.NumberGenerator;

public class RandomNumberAccelerator implements Accelerator {
    private static final Integer BOUND_NUMBER = 4;

    private final NumberGenerator numberGenerator;

    public RandomNumberAccelerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public void move(Car car) {

        if (canMove(numberGenerator.generate())) {
            car.moveForward();
        }
    }

    @Override
    public boolean canMove(int number) {
        return number >= BOUND_NUMBER;
    }
}
