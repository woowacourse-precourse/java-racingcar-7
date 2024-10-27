package racingcar.validate;

import racingcar.exception.ErrorMessage;
import racingcar.exception.GameException;

import java.util.HashSet;
import java.util.regex.Pattern;

public class Validator {
    final HashSet<String> names;
    final int MAX_LEN = 5;

    Validator() {
        this.names = new HashSet<>();
    }

    public void validateName(String name) {
        if (isBlank(name)) {
            throw new GameException(ErrorMessage.INPUT_NOT_BLANK);
        } else if (isLong(name)) {
            throw new GameException(ErrorMessage.LONG_NAME);
        } else if (isExist(name)) {
            throw new GameException(ErrorMessage.EXIST_NAME);
        } else if (!isEnglish(name)) {
            throw new GameException(ErrorMessage.NOT_ENGLISH);
        }
    }

    public void validateNum(String name) {
        if (isBlank(name)) {
            throw new GameException(ErrorMessage.INPUT_NOT_BLANK);
        } else if (!isNum(name)) {
            throw new GameException(ErrorMessage.NOT_NUM);
        }
    }

    private boolean isBlank(String name) {
        return name.isBlank();
    }

    private boolean isLong(String name) {
        return name.length() > 5;
    }

    private boolean isExist(String name) {
        if (names.contains(name)) {
            return true;
        } else {
            names.add(name);
            return false;
        }
    }

    private boolean isEnglish(String name) {
        return Pattern.matches("^[A-Za-z]*$", name);
    }

    private boolean isNum(String name) {
        return Pattern.matches("^[0-9]*$", name);
    }
}
