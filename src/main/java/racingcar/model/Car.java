package racingcar.model;

import static racingcar.common.exception.ErrorMessage.CAR_NAME_BLANK_ERROR;
import static racingcar.common.exception.ErrorMessage.CAR_NAME_LENGTH_ERROR;
import static racingcar.common.exception.ErrorMessage.CAR_NAME_NULL_ERROR;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        Validator.validateName(name);
        this.name = name;
        this.position = 0;
    }

    public void drive(DriveStrategy driveStrategy) {
        position = driveStrategy.drive(position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private static class Validator {

        public static final int CAR_NAME_LENGTH = 5;

        private static void validateName(String name) {
            validateNotNull(name);
            validateNotBlank(name);
            validateLength(name);
        }

        private static void validateNotNull(String name) {
            if (name == null) {
                throw new IllegalArgumentException(CAR_NAME_NULL_ERROR);
            }
        }

        private static void validateNotBlank(String name) {
            if (name.isBlank()) {
                throw new IllegalArgumentException(CAR_NAME_BLANK_ERROR);
            }
        }

        private static void validateLength(String name) {
            if (name.length() > CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
            }
        }
    }
}
