package racingcar.domain;

public class CarValidation {

    public static void checkCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
