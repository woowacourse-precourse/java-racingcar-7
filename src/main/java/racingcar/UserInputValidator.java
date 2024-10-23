package racingcar;

public class UserInputValidator {
    public static boolean isValidCarName(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidTryCount(String tryCount) {
        return tryCount.chars().allMatch(Character::isDigit) && Integer.parseInt(tryCount) > 0;
    }
}
