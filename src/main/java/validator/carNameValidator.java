package validator;

import java.util.List;
import java.util.regex.Pattern;

public class carNameValidator {
    // 정규식 패턴 객체를 상수로 정의
    private static final Pattern VALID_NAME_PATTERN = Pattern.compile("^[a-zA-Z가-힣].*");

    public static void isValid(List<String> carNames) {
        for (String name : carNames) {
            validateSingleCarName(name);
        }

    }

    public static void isBlank(String input) {
        if (input.equals(" ")) {
            throw new IllegalArgumentException("자동차 이름은 공백이 될 수 없습니다.");
        }
    }

    public static void checkEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 최소 하나 이상이어야 합니다.");
        }
    }

    public static void validateSingleCarName(String input) {
        checkEmpty(input);
        checkCarNameLength(input);
        isBlank(input);
        startsWithValidCharacter(input);
    }

    public static void checkCarNameLength(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 넘을 수 없습니다: " + input);
        }
    }

    public static void startsWithValidCharacter(String input) {
        // 첫 글자가 영문자(a-zA-Z) 또는 한글(가-힣)로 시작하는지 확인
        if (!VALID_NAME_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("자동차 이름의 첫 글자는 영문자 또는 한글이어야 합니다.");
        }

    }


}
