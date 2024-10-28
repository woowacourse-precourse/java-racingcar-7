package racingcar.domain;

import static racingcar.domain.CarCondition.*;

public class CarValidation {

    public static void checkCarNameLength(String carName) {
        if (carName.length() > NAME_LENGTH.getCondition()) {
            throw new IllegalArgumentException();
        }
    }
}
