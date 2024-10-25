package racingcar;

public class UserInputValidator {
    public static boolean isOneRacingCar(String[] carNames) {
        return carNames.length > 1;
    }

    public static boolean isValidRacingCarName(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumberTryCount(String tryCount) {
        return tryCount.chars().allMatch(Character::isDigit);
    }

    public static boolean isNotTooBigTryCount(String tryCount) {
        return tryCount.length() < 19;
    }

    public static boolean isPositiveTryCount(String tryCount) {
        return Long.parseLong(tryCount) > 0;
    }
}
