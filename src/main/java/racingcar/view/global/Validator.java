package racingcar.view.global;

public class Validator {
    public static void validString(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
