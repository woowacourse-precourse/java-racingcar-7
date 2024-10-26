package racingcar.domain;

import java.util.Objects;

import static racingcar.constant.RacingConstant.RACING_CAR_MOVE_LIMIT;
import static racingcar.constant.RacingConstant.RACING_CAR_NAME_MAX_LENGTH;
import static racingcar.message.ErrorMessage.CAR_NAME_MAX_LENGTH;
import static racingcar.message.ErrorMessage.CAR_NAME_REQUIRED;

public class RacingCar {

    private final String name;
    private int position = 0;

    public RacingCar(String name) {
        name = name.strip();

        validateCarName(name);

        this.name = name;
    }

    private void validateCarName(String name) {
        if (isCarNameEmpty(name)) {
            throw new IllegalArgumentException(CAR_NAME_REQUIRED.getMessage());
        }

        if (isCarNameLengthExceeded(name)) {
            throw new IllegalArgumentException(CAR_NAME_MAX_LENGTH.getMessage());
        }
    }

    public void move(int numberValue) {
        if (isStopByNumberValue(numberValue)) {
            return;
        }

        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private boolean isCarNameEmpty(String name) {
        return name.isEmpty();
    }

    private boolean isCarNameLengthExceeded(String name) {
        return name.length() > RACING_CAR_NAME_MAX_LENGTH;
    }

    private boolean isStopByNumberValue(int numberValue) {
        return numberValue < RACING_CAR_MOVE_LIMIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(getName(), racingCar.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}
