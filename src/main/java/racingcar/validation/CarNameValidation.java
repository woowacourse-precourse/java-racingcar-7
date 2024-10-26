package racingcar.validation;

public class CarNameValidation {
    private static final Integer CAR_NAME_LIMIT = 5;

    public static boolean validateCarNameLength(String carName) {
        return carName.length() > CAR_NAME_LIMIT;
    }
}
