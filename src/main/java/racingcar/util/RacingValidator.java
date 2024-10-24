package racingcar.util;

import java.util.HashSet;
import java.util.List;

public class RacingValidator {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    public static void isCarNameInput(String input) {
        List<String> nameList = List.of(input.split(","));
        isValidNameListSize(nameList);
        isValidNameLength(nameList);
        isValidDuplicateName(nameList);
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

    private static void isValidDuplicateName(List<String> nameList) {
        int validLength = new HashSet<>(nameList).size();
        if (validLength != nameList.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }


}
