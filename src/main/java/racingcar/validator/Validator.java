package racingcar.validator;


import racingcar.exception.EmptyNameException;
import racingcar.exception.OverLimitedNameException;
import static racingcar.constant.Constant.NAME_LENGTH_LIMIT;

public class Validator {

    public void isValidName(String carName) {
        if (carName.isEmpty() || carName == null) {
            throw new EmptyNameException();
        }
        if (carName.length() > NAME_LENGTH_LIMIT) {
            throw new OverLimitedNameException();
        }

    }

}
