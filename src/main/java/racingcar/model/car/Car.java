package racingcar.model.car;

import static java.lang.String.format;
import static java.util.Objects.isNull;
import static racingcar.common.constant.SystemConstant.CAR_NAME_MIN_LENGTH;

import racingcar.common.exception.LengthExceedException;
import racingcar.common.exception.ShouldNotBeNullException;
import racingcar.model.race.Distance;
import racingcar.util.RandomUtil;

public class Car {
    private final String name;
    private final MyProgress myProgress;

    private Car(final String name, final MyProgress myProgress) {
        this.name = name;
        this.myProgress = myProgress;
    }

    public static Car from(final String name, final MyProgress myProgress) {
        validateIsNull(name);
        validateNameLength(name);
        return new Car(name, myProgress);
    }

    public boolean completedAllLap() {
        return myProgress.completedAllLap();
    }

    public Distance movableDistance() {
        int movementValue = RandomUtil.generateRandomNum();
        MovementCondition condition = MovementCondition.getConditionBy(movementValue);
        return condition.getDistance();
    }

    public void updateProgress(final Distance distance) {
        if (distance.isBiggerThanZero()) {
            myProgress.updatePosition(distance);
            myProgress.updateRemainingLap();
        }
    }

    public String myProgressSummary() {
        return format("%s : %s", name, myProgress.toString());
    }

    private static void validateIsNull(final String name) {
        if (isNull(name)) {
            throw new ShouldNotBeNullException();
        }
    }

    private static void validateNameLength(final String name) {
        boolean longerThanMinLength = name.length() > CAR_NAME_MIN_LENGTH;
        if (longerThanMinLength) {
            throw new LengthExceedException(CAR_NAME_MIN_LENGTH);
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
