package racingcar;

public class UserInputValidator {
    public static boolean isValidRacingCarName(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidTryCount(String tryCount) {
        return tryCount.chars().allMatch(Character::isDigit) && tryCount.length() < 20 && Long.parseLong(tryCount) > 0;
    }
}
