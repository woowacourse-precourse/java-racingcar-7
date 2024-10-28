package racingcar.util;

public class CarNameValidator {

    public static final String WHITE_SPACE_REGEX = "\\s";
    public static final String VALID_CHARACTER_REGEX = "^[a-zA-Z가-힣0-9]*$";

    public static void validate(String carName) {

        isEmpty(carName);
        validateRange(carName);
        hasSymbol(carName);
        hasWhiteSpace(carName);
    }

    private static void isEmpty(String carName) {

        if (carName.trim().isEmpty()) {
            throw new IllegalArgumentException("비어있는 자동차 이름이 있습니다.");
        }
    }

    private static void validateRange(String carName) {

        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하로 입력해야 합니다.");
        }
    }

    private static void hasSymbol(String carName) {

        if (!carName.replaceAll(WHITE_SPACE_REGEX, "").matches(VALID_CHARACTER_REGEX)) {
            throw new IllegalArgumentException("이름은 기호를 포함할 수 없습니다.");
        }
    }

    private static void hasWhiteSpace(String carName) {

        int origin_carName_length = carName.length();
        int without_space_carName_length = carName.replaceAll(WHITE_SPACE_REGEX, "").length();

        if (origin_carName_length != without_space_carName_length) {
            throw new IllegalArgumentException("이름은 공백을 포함할 수 없습니다.");
        }
    }
}
