package racingcar.validator;

import java.util.HashSet;
import racingcar.exception.RacingException;
import racingcar.view.ErrorMessage;

public class CarNameValidator {

    public String isValid(String carName, HashSet<String> carNameSet) {
        if (carName.isEmpty()) {
            throw RacingException.from(ErrorMessage.CAR_NAME_IS_EMPTY);
        }

        carName = carName.stripLeading().stripTrailing();

        if (carName.isEmpty()) {
            throw RacingException.from(ErrorMessage.CAR_NAME_IS_SPACE);
        }

        if(carNameSet.contains(carName)) {
            throw RacingException.from(ErrorMessage.CAR_NAME_IS_DUPLICATED);
        }

        if (carName.length() > 5) {
            throw RacingException.from(ErrorMessage.CAR_NAME_IS_TOO_LONG);
        }

        return carName;
    }
}
