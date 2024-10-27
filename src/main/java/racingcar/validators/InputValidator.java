package racingcar.validators;

import java.util.List;

public class InputValidator {

    public static void validateCharacters(List<String> names) {
        final String englishRegex = "a-zA-Z";
        final String koreanRegex = "ㄱ-ㅎㅏ-ㅣ가-힣";

        if (!names.stream().allMatch(name -> name.matches("^[" + englishRegex + koreanRegex + "]*$"))) {
            throw new IllegalArgumentException("이름에 허용되지 않는 문자가 들어가 있습니다 (한국어+영어만 가능).");
        }
    }

    public static void validateLength(List<String> names) {
        final int MAX_NAME_LENGTH = 5;

        if (names.stream().anyMatch(name -> name.length() > MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException("각 이름의 길이는 " + MAX_NAME_LENGTH + "자를 넘길 수 없습니다.");
        }

        if (names.stream().anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException("빈 이름이 존재합니다.");
        }
    }

    public static void validateDuplicates(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException("중복되는 이름이 존재합니다.");
        }
    }

    public static void validateMaxCarCount(List<String> names) {
        final int MAX_CAR_COUNT = 100;
        if (names.size() > MAX_CAR_COUNT) {
            throw new IllegalArgumentException("차의 대수는 " + MAX_CAR_COUNT + "대를 넘길 수 없습니다.");
        }
    }

    public static void validateNumber(String input) {
        final int MIN_ROUND_COUNT = 1;
        final int MAX_ROUND_COUNT = 10000;

        try {
            if (Integer.parseInt(input) < MIN_ROUND_COUNT) {
                throw new IllegalArgumentException("시도할 횟수는 " + MIN_ROUND_COUNT + " 이상이어야 합니다.");
            } else if (Integer.parseInt(input) > MAX_ROUND_COUNT) {
                throw new IllegalArgumentException("시도할 횟수는 " + MAX_ROUND_COUNT + " 이하여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다.");
        }
    }
}
