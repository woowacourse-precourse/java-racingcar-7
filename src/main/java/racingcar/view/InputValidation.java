package racingcar.view;

public class InputValidation {

    public static void checkIsNumber(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }
}
