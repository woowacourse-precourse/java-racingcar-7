package racingcar.common;

public class StringSizeValidator {

    public static void checkBlank(String s) {
        if (s.isBlank()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
    }
    public static void checkLimitedSize(String string, int size) {
        if (string.length() > size) {
            throw new IllegalArgumentException("length of string's is over "+size);
        }
    }
}
