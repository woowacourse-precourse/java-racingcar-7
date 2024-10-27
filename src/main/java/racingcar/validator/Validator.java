package racingcar.validator;

import java.util.List;
import racingcar.util.Util;

public class Validator {

    public boolean validateNames(String string) {
        if (string.isEmpty() || isOverOne(string)) {
            isOverOne(string);
        }
        List<String> names = Util.splitByComma(string);
        names.forEach(name -> isLimitExceed(name, 5));
        return true;
    }

    private boolean isOverOne(String string) {
        return Util.splitByComma(string).size() <= 1;
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
