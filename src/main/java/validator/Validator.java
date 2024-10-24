package validator;

import exception.ErrorCode;
import java.util.List;

public class Validator {
    private static final String EMPTY_STRING = "";

    public void validateCar(List<String> carNames) {
        checkCarNotEmpty(carNames);
    }

    private void checkCarNotEmpty(List<String> carNames) {
        if (carNames.stream().anyMatch(
                name -> name.trim().isEmpty())) {
            throw new IllegalArgumentException(ErrorCode.EMPTY_CAR_NAME.getMessage());
        }
    }
}
