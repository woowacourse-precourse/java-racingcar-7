package racingcar.domain;

import static racingcar.common.ExceptionMessage.*;
import static racingcar.common.RacingCarConstant.*;
import static racingcar.common.RacingCarConstant.DEFAULT_STATE;
import static racingcar.common.RacingCarConstant.FORWARD_BAR;

public class CarRacer extends Racer {

    private String name;
    private String progressState;

    private CarRacer() {
    }

    private CarRacer(String name) {
        validateNameLength(name);
        this.name = name;
        this.progressState = DEFAULT_STATE;
    }

    public String getName() {
        return name;
    }

    public String getProgressState() {
        return progressState;
    }

    public void forward() {
        progressState += FORWARD_BAR;
    }

    public static CarRacer from(String name) {
        return new CarRacer(name);
    }

    @Override
    public String toString() {
        return name + PROGRESS_SEPARATOR + progressState;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_OVER_LENGTH_EXCEPTION);
        }
    }
}
