package racingcar.strategy;

import racingcar.util.RandomNumberCalculator;

public class MovementStrategy implements CarStrategy {
    private static final Integer MOVEMENT_CRITERION_NUMBER = 4;

    @Override
    public boolean move() {
        return RandomNumberCalculator.getRandomNumber() >= MOVEMENT_CRITERION_NUMBER;
    }
}