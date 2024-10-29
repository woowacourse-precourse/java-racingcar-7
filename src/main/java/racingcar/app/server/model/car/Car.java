package racingcar.app.server.model.car;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static racingcar.app.server.error.ErrorMessage.SHOULD_NOT_BE_NULL;

import racingcar.app.server.exception.LengthExceedException;
import racingcar.app.server.model.location.Distance;
import racingcar.app.server.model.race.Lap;

public class Car {

    public static int CAR_NAME_MIN_LENGTH = 5;

    private final String name;
    private final MyProgress myProgress;


    private Car(final String name, final MyProgress myProgress) {
        this.name = name;
        this.myProgress = myProgress;
    }

    public static Car of(final String name, final MyProgress myProgress) {
        requireNonNull(name, SHOULD_NOT_BE_NULL);
        validateNameLength(name);
        return new Car(name, myProgress);
    }

    public boolean completedAllLap() {
        return myProgress.completedAllLap();
    }

    public Distance movableDistance() {
        Speed randomSpeed = Speed.generateRandomSpeed();
        return MovementCondition.getMovableDistanceBy(randomSpeed);
    }

    public void updateProgress(final Distance distance, Lap countDownAmount) {
        myProgress.updateDistance(distance);
        myProgress.countDownRemainingLap(countDownAmount);
    }

    public String myProgressSummary() {
        String position = myProgress.currentPosition().toString();
        return format("%s : %s", name, position);
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
