package racingcar;

import java.util.List;

public class NameValidator {

    public static void carNameLengthChecker(List<String> carName) {
        for (String name : carName) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
