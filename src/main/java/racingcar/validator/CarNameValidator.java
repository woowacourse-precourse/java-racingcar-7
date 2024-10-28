package racingcar.validator;

import java.util.Set;
import racingcar.exception.RacingException;
import racingcar.view.ErrorMessage;

public class CarNameValidator {

    public String checkCarName(String carName, Set<String> carNameSet) {
        if (carName.isEmpty()) {
            throw RacingException.from(ErrorMessage.CAR_NAME_IS_EMPTY.getMessage());
        }

        carName = carName.stripLeading().stripTrailing();

        if (carName.isEmpty()) {
            throw RacingException.from(ErrorMessage.CAR_NAME_IS_SPACE.getMessage());
        }

        if (carNameSet.contains(carName)) {
            throw RacingException.from(ErrorMessage.CAR_NAME_IS_DUPLICATED.getMessage());
        }

        if (carName.length() > 5) {
            throw RacingException.from(ErrorMessage.CAR_NAME_IS_TOO_LONG.getMessage());
        }

        carNameSet.add(carName);

        return carName;
    }
}
