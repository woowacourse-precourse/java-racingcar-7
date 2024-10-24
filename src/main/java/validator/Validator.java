package validator;

import exception.ErrorCode;
import java.util.List;

public class Validator {

    public void validateCar(List<String> carNames) {
        checkCarNotEmpty(carNames);
    }

    private void checkCarNotEmpty(List<String> carNames) {
        if (carNames.stream().anyMatch(
                String::isEmpty)) {
            throw new IllegalArgumentException(ErrorCode.EMPTY_CAR_NAME.getMessage());
        }
    }
}
