package racingcar.validator;

import racingcar.exception.EmptyNameException;
import racingcar.exception.OverLimitedNameException;

public class Validator {

    public void isValidName(String carName) {
        if (carName.isEmpty() || carName == null) {
            throw new EmptyNameException();
        }
        if (carName.length() > 5) {
            throw new OverLimitedNameException();
        }

    }

}
