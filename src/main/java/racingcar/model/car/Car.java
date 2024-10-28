package racingcar.model.car;

import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarException;
import racingcar.model.car.strategy.MoveBehavior;

public class Car {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final MoveBehavior moveBehavior;
    private final String name;
    private int movedDistance;

    public Car(MoveBehavior moveBehavior, String name) {
        validateName(name);
        this.moveBehavior = moveBehavior;
        this.name = name;
        movedDistance = 0;
    }


    public void move() {
        int moveAmount = moveBehavior.getMoveAmount();
        movedDistance += moveAmount;

    }

    public String getName() {
        return this.name;
    }

    public int getMovedDistance() {
        return this.movedDistance;
    }

    private static void validateName(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new RacingCarException(ErrorMessage.EMPTY_CAR_NAME);
        }
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new RacingCarException(ErrorMessage.CAR_NAME_TOO_LONG);
        }
    }
}
