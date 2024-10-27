package racingcar.util;

import racingcar.exception.RacingException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingUtils {

    private static final int LENGTH = 5;

    public static List<String> divideComma(String input) {
        List<String> list = Arrays.stream(input.split(",")).map(String::trim).toList();// ,로 나눠 리스트에 나눠담음

        RacingException.throwIllegalArgumentException("잘못된 입력입니다.", hasEmptyOrBlankString(list) || isSingleName(list));
        RacingException.throwIllegalArgumentException("잘못된 입력입니다.", hasDuplicates(list) || hasAnyStringExceedingLength(list));

        return list;
    }

    public static boolean hasDuplicates(List<String> list) {
        Set<String> set = new HashSet<>(list);
        return set.size() != list.size(); // 중복일 경우 true
    }

    public static int parseInt(String input) {
        int result = 0;

        try {
            result = Integer.parseInt(input);

            RacingException.throwIllegalArgumentException("잘못된 입력입니다.", isNotPositive(result));
        } catch (NumberFormatException e) {
            RacingException.throwIllegalArgumentException("잘못된 입력입니다.");
        }

        return result;
    }

    public static String joinWithCommaAndWhiteSpace(List<String> names) {
        return String.join(", ", names);
    }

    public static boolean isNotPositive(int number) {
        return number <= 0;
    }

    private static boolean hasAnyStringExceedingLength(List<String> list) {
        return list.stream().anyMatch(RacingUtils::hasStringExceedingLength);
    }

    private static boolean hasStringExceedingLength(String string) {
        return string.length() > LENGTH;
    }

    private static boolean hasEmptyOrBlankString(List<String> list) {
        return list.stream().anyMatch(String::isBlank);
    }

    private static boolean isSingleName(List<String> list) {
        return list.size() <= 1;
    }

}
