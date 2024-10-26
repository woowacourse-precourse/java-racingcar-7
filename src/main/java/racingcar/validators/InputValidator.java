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
}
