package racingcar;

import java.util.List;

public class InputValidator {


    public static void validateCarName(List<String> carNames) {
        if(carNames.isEmpty() || carNames.size() > 30) {
            throw new IllegalArgumentException(ErrorMessages.CAR_COUNT_OUT_OF_RANGE);
        }
        for(String carName : carNames) {
            if(carName.length() > 5 || carName.length() < 1 || !carName.matches("[a-zA-Z]+$")) {
                throw new IllegalArgumentException(ErrorMessages.CAR_NAME_NOT_VALID);
            }
        }
    }
    public static void validateTryCount(String count) {
        if(count == null) {
            throw new IllegalArgumentException(ErrorMessages.TRY_COUNT_OUT_OF_RANGE);
        }
        try {
            Integer tryCount = Integer.parseInt(count);
            if(tryCount < 0 || tryCount > 30) {
                throw new IllegalArgumentException(ErrorMessages.TRY_COUNT_OUT_OF_RANGE);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.TRY_COUNT_NOT_VALID);
        }
    }
}
