package racingcar.validator;

import java.util.List;
import racingcar.util.Util;

public class Validator {

    public static final int NAME_LENGTH_LIMIT = 5;

    public boolean validateNames(String string) {
        if (string.isEmpty() || isSingleName(string)) {
            throw new IllegalArgumentException();
        }
        List<String> names = Util.splitByComma(string);
        names.forEach(name -> isLimitExceed(name, NAME_LENGTH_LIMIT));
        return true;
    }

    private boolean isSingleName(String string) {
        return Util.splitByComma(string).size() == 1;
    }

    private void isLimitExceed(String string, int limit) {
        if (string.length() > limit) {
            throw new IllegalArgumentException();
        }
    }

    public void validateTimes(Long times) {
        if (times <= 0L) {
            throw new IllegalArgumentException();
        }
    }
}
