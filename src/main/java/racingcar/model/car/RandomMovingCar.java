package racingcar.model.car;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarException;

public class RandomMovingCar implements Car {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MOVEMENT_THRESHOLD = 4;

    private final String name;
    private int movedDistance;

    public RandomMovingCar(String name) {
        validateName(name);
        this.name = name;
        movedDistance = 0;
    }


    @Override
    public void move() {
        if (Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= MOVEMENT_THRESHOLD) {
            movedDistance++;
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
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
