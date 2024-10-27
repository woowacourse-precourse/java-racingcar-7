package racingcar.service;

public class InputValidator {

    private static final int MINIMUM_CAR_NAME_SIZE = 1;
    private static final int MINIMUM_CAR_NAME_LENGTH = 5;
    private static final int MINIMUM_TRY_COUNT = 1;

    public void validateCarNames(String[] carNames) {

        if (carNames.length < MINIMUM_CAR_NAME_SIZE) {
            throw new IllegalArgumentException();
        }

        for (String carName : carNames) {

            int lengthWithoutBlank = carName.replace(" ", "").length();

            if (carName.isBlank()) {
                throw new IllegalArgumentException();
            }
            if (lengthWithoutBlank < MINIMUM_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateTryCount(int tryCount) {
        if (tryCount < MINIMUM_TRY_COUNT) {
            throw new IllegalArgumentException();
        }
    }
}
