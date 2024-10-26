package racingcar.exception;

import java.util.List;
import racingcar.validation.CarValidation;

public class RacingException {
    public static void separatorException(String carNames) {
        if (CarValidation.validateCarNameSeparator(carNames)) {
            throw new CarNameSeparatorException();
        }
    }

    public static void emptyException(List<String> carNameList) {
        if (CarValidation.validateCarNameEmpty(carNameList)) {
            throw new CarNameEmptyException();
        }
    }

    public static void duplicationException(List<String> carNameList) {
        if (CarValidation.validateCarNameDuplication(carNameList)) {
            throw new CarNameDuplicationException();
        }
    }
}
