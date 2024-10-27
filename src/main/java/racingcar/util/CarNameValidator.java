package racingcar.util;

public class CarNameValidator {

    private static final int CAR_NAME_MAX_LENGTH = 5;

    public static boolean isWithinMaxLength(String carName) {
        
        return carName.length() > CAR_NAME_MAX_LENGTH;
    }

    public static boolean isEmpty(String[] cars) {

        return cars.length == 0;
    }
}
