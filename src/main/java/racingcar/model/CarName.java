package racingcar.model;

import java.util.Objects;
import racingcar.constants.ErrorMessage;

public class CarName {
    private static final int MAX_CAR_NAME = 5;
    private static final String BLANK = " ";

    private final String carName;

    public CarName(String carName) {
        validateLength(carName);
        validateHasBlank(carName);
        this.carName = carName;
    }

    public static void validateLength(String carName) {
        if (carName.isBlank() || carName.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_MIN_ONE_MAX_FIVE.getErrorMessage());
        }
    }

    public static void validateHasBlank(String carName) {
        if (carName.contains(BLANK)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_MUST_NOT_HAVE_BLANK.getErrorMessage());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CarName comparingCarName = (CarName) obj;
        return Objects.equals(carName, comparingCarName.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }

    public String getCarName() {
        return carName;
    }
}
