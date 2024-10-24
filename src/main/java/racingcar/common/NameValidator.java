package racingcar.common;

public class NameValidator {

    public static void isNotBlank(String s) {
        if (s.isBlank()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
    }
    public static void isValidSize(String s) {
        if (s.length() > 5) {
            throw new IllegalArgumentException("size of member's name is over 5");
        }
    }
}
