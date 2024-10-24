package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataParser {
    public static List<String> parseName(String input) {
        List<String> list = Arrays.asList(input.split(","));

        isNonEmpty(list);
        checkLenght(list);
        isAlphaNumeric(list);

        int tryCount = parseCount(IOHandler.inputTryCount());
        return list;
    }

    private static int parseCount(String tryCount) {
        for (char c : tryCount.toCharArray()) {
            if (Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
        return Integer.parseInt(tryCount);
    }

    private static void isAlphaNumeric(List<String> list) {
        for (String input : list) {
            isLetterOrDigit(input);
        }
    }

    private static void isLetterOrDigit(String input) {
        for (char c : input.toCharArray()) {
            if ((!Character.isLetter(c) || Character.isDigit(c))) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void checkLenght(List<String> list) {
        final int MAX_LENGHT = 5;

        for (String s : list) {
            if (s.length() > MAX_LENGHT) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void isNonEmpty(List<String> list) {
        List<String> trimmdlist = new ArrayList<>();
        for (String s : list) {
            if (s.isBlank()) {
                throw new IllegalArgumentException();
            }
            trimmdlist.add(s.trim());
        }

        list.clear();
        list.addAll(trimmdlist);
    }

}
