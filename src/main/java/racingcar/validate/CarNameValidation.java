package racingcar.validate;

public class CarNameValidation {
    public static void validateName(String name) {
        validateIfCarNameIsNUllOrEmpty(name);
        validateIfCarNameLengthWithinFive(name);
    }

    public static void validateIfCarNameIsNUllOrEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 지어주세요.");
        }
    }

    public static void validateIfCarNameLengthWithinFive(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(
                    "자동차 이름은 5글자 이하여야 합니다.");
        }
    }
}
