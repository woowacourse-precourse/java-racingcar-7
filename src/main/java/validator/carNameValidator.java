package validator;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import util.ParsingUtil;

public class carNameValidator {
    // 정규식 패턴 객체를 상수로 정의, 영문자/한글/숫자만 허용하고 특수문자는 제외
    private static final Pattern VALID_NAME_PATTERN = Pattern.compile("^[a-zA-Z가-힣0-9]+$");

    public static void isValid(List<String> carNames) {
        for (String name : carNames) {
            checkSingleCarName(name);
        }

        checkDuplicateNames(carNames);

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

    public static void checkSingleCarName(String input) {
        checkEmpty(input);
        checkCarNameLength(input);
        isBlank(input);
        checkspecialCharacters(input);
    }

    public static void checkCarNameLength(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 넘을 수 없습니다: " + input);
        }
    }

    public static void checkspecialCharacters(String input) {
        if (!VALID_NAME_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("특수문자는 포함시킬 수 없습니다.");
        }

    }

    //대소문자는 구별한다.
    public static void checkDuplicateNames(List<String> carNames) {
        carNames = ParsingUtil.DuplicateNames(carNames);
        if (carNames.size() != new HashSet<>(carNames).size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

}
