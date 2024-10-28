package racingcar.util;

public class CarNameValidator {

    private CarNameValidator() {

    }

    public static void checkCarNameEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
