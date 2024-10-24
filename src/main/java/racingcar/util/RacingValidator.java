package racingcar.util;

import java.util.List;

public class RacingValidator {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    public static void isCarNameInput(String input) {
        List<String> nameList = List.of(input.split(","));
        isValidNameListSize(nameList);
        isValidNameLength(nameList);
    }

    private static void isValidNameListSize(List<String> nameList) {
        if (nameList.isEmpty() || nameList.size() == 1) {
            throw new IllegalArgumentException();
        }
    }

    private static void isValidNameLength(List<String> nameList) {
        boolean validLength = nameList.stream()
                .anyMatch(s -> s.length() < MIN_NAME_LENGTH || s.length() > MAX_NAME_LENGTH);
        if (validLength) {
            throw new IllegalArgumentException();
        }
    }


}
