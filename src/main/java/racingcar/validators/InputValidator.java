package racingcar.validators;

import java.util.List;
import racingcar.common.Languages;
import racingcar.common.Ranges;

public class InputValidator {

    public static void validateCharacters(List<String> names) {
        if (!names.stream().allMatch(name -> name.matches(
                "^[" + Languages.ENGLISH.getRegex() + Languages.KOREAN.getRegex() + "]*$"
        ))) {
            throw new IllegalArgumentException("이름에 허용되지 않는 문자가 들어가 있습니다 (한국어+영어만 가능).");
        }
    }

    public static void validateLength(List<String> names) {
        if (names.stream().anyMatch(name -> name.length() > Ranges.MAX_NAME_LENGTH.getValue())) {
            throw new IllegalArgumentException("각 이름의 길이는 " + Ranges.MAX_NAME_LENGTH.getValue() + "자를 넘길 수 없습니다.");
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
        if (names.size() > Ranges.MAX_CARS.getValue()) {
            throw new IllegalArgumentException("차의 대수는 " + Ranges.MAX_CARS.getValue() + "대를 넘길 수 없습니다.");
        }
    }

    public static void validateNumber(String input) {
        try {
            if (Integer.parseInt(input) < Ranges.MIN_ROUNDS.getValue()) {
                throw new IllegalArgumentException(
                        "시도할 횟수로 " + Ranges.MIN_ROUNDS.getValue() + " 이상의 값을 입력해주세요.");
            } else if (Integer.parseInt(input) > Ranges.MAX_ROUNDS.getValue()) {
                throw new IllegalArgumentException(
                        "시도할 횟수가 너무 큽니다. " + Ranges.MAX_ROUNDS.getValue() + " 이하의 값을 입력해주세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다.");
        }
    }
}
