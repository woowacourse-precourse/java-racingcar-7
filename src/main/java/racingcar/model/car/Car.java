package racingcar.model.car;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static racingcar.common.message.ErrorMessage.SHOULD_NOT_BE_NULL;

import racingcar.common.exception.LengthExceedException;
import racingcar.model.position.Distance;
import racingcar.model.race.Lap;
import racingcar.util.RandomUtil;

public class Car {

    public static int CAR_NAME_MIN_LENGTH = 5;

    private final String name;
    private final MyProgress myProgress;


    // Constructor
    private Car(final String name, final MyProgress myProgress) {
        this.name = name;
        this.myProgress = myProgress;
    }

    public static Car from(final String name, final MyProgress myProgress) {
        requireNonNull(name, SHOULD_NOT_BE_NULL);
        validateNameLength(name);
        return new Car(name, myProgress);
    }

    // Method
    public boolean completedAllLap() {
        return myProgress.completedAllLap();
    }

    public Distance movableDistance() {
        int movementValue = RandomUtil.generateRandomNum();
        MovementCondition condition = MovementCondition.getConditionBy(movementValue);
        return condition.getDistance();
    }

    public void updateProgress(final Distance distance, Lap countDownAmount) {
        myProgress.updatePosition(distance);
        myProgress.countDownRemainingLap(countDownAmount);
    }

    public String myProgressSummary() {
        return format("%s : %s", name, myProgress.toString());
    }

    @Override
    public String toString() {
        return this.name;
    }

    // validation
    private static void validateNameLength(final String name) {
        boolean longerThanMinLength = name.length() > CAR_NAME_MIN_LENGTH;
        if (longerThanMinLength) {
            throw new LengthExceedException(CAR_NAME_MIN_LENGTH);
        }
    }
}
