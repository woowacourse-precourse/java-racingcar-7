package racingcar.util;

public abstract class CustomValidator {

    public static boolean validateLength(String carName) {
        return carName.length() <= 5;
    }

    public static boolean validateNumber(String str) {
        return str.chars().allMatch(Character::isDigit);
    }
}
