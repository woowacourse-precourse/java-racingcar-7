package racingcar.validation;

import java.util.List;
import java.util.HashSet;
import racingcar.exception.Exception;

public class NamesValidation {

    public static void isUnderOne(String carNames) {
        if (!carNames.contains(",")) {
            Exception.exceptionUnderCars();
        }
    }

    public static void isEmptyName(List<String> carNames, String inputCarName) {
        int index = 0, count = 0;
        while (index < inputCarName.length()) {
            if (inputCarName.charAt(index) == ',') {
                count++;
            }
            index++;
        }
        if (carNames.size() != count + 1) {
            Exception.exceptionNameEmpty();
        }
    }

    public static void isOverRangeName(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                Exception.exceptionNameOverFive();
            }
        }
    }

    public static void isDuplicateName(List<String> carNames) {
        HashSet<String> names = new HashSet<>(carNames);
        if (names.size() < carNames.size()) {
            Exception.exceptionNameDuplicate();
        }
    }

}
