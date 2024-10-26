package racingcar.util;

import racingcar.exception.RacingException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingUtils {

    public static List<String> divideComma(String input) {
        if (hasWhitespaceAroundComma(input)) {
            input = replaceWhitespaceAroundComma(input);
        }

        List<String> list = Arrays.stream(input.split(",")).toList();
        RacingException.throwIllegalArgumentException("잘못된 입력입니다.", hasDuplicates(list));

        return list;
    }

    public static boolean hasWhitespaceAroundComma(String input) {
        return input.contains(", ") || input.contains(" ,");
    }

    public static String replaceWhitespaceAroundComma(String input) {
        input = input.replace(" ,", ",");
        input = input.replace(", ", ",");

        return input;
    }

    public static boolean hasDuplicates(List<String> list) {
        Set<String> set = new HashSet<>(list);
        return set.size() != list.size(); // 중복일 경우 true
    }

}
