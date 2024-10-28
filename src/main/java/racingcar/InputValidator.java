package racingcar;

public class InputValidator {

    public static void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

}
