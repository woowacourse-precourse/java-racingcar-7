package racingcar.strategy;

import racingcar.util.RandomNumberCreator;

public class MovementStrategy implements CarStrategy {
    private static final Integer MOVEMENT_CRITERION_NUMBER = 4;

    @Override
    public boolean move() {
        return RandomNumberCreator.getRandomNumber() >= MOVEMENT_CRITERION_NUMBER;
    }
}