package racingcar.model.carname;

import racingcar.exception.CarNameLengthExceedException;

public class CarNameValidation {
    private static final int MAX_NAME_LENGTH = 5;

    public static void carNameValidate(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_NAME_LENGTH) {
                throw new CarNameLengthExceedException();
            }
        }
    }
}
