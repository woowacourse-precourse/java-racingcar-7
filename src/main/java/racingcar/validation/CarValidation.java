package racingcar.validation;

public class CarValidation {
    private static final String NAME_SEPARATOR = ",";

    public static boolean validateCarNameSeparator(String carNames) {
        return !carNames.contains(NAME_SEPARATOR);
    }
}
