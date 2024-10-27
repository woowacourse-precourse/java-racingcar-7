package racingcar.app.server.model.car;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static racingcar.app.server.error.ErrorMessage.SHOULD_NOT_BE_NULL;
import static racingcar.app.server.model.car.MovementCondition.getDistanceBy;

import racingcar.app.server.exception.LengthExceedException;
import racingcar.app.server.model.position.Distance;
import racingcar.app.server.model.race.Lap;

public class Car {

    public static int CAR_NAME_MIN_LENGTH = 5;

    private final String name;
    private final MyProgress myProgress;


    private Car(final String name, final MyProgress myProgress) {
        this.name = name;
        this.myProgress = myProgress;
    }

    public static Car from(final String name, final MyProgress myProgress) {
        requireNonNull(name, SHOULD_NOT_BE_NULL);
        validateNameLength(name);
        return new Car(name, myProgress);
    }

    public boolean completedAllLap() {
        return myProgress.completedAllLap();
    }

    public Distance movableDistance() {
        Speed randomSpeed = SpeedGenerator.generateRandomSpeed();
        return getDistanceBy(randomSpeed);
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

    private static void validateNameLength(final String name) {
        boolean longerThanMinLength = name.length() > CAR_NAME_MIN_LENGTH;
        if (longerThanMinLength) {
            throw new LengthExceedException(CAR_NAME_MIN_LENGTH);
        }
    }
}
