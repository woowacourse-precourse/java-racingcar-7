package racingcar.util;

public class Validator {

    private final static int MAX_CAR_NAME_LENGTH = 5;
    private final static int VALIDATE_NEGATIVE_NUMBER = 0;

    public static boolean isMoreFour(int randomNumber) {
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }

    public static boolean validateCarName(String name) {
        int nameLength = name.length();
        if (nameLength > MAX_CAR_NAME_LENGTH){
            return false;
        }
        return true;
    }

    public static boolean validateTryCount(int tryCount) {
        if (tryCount < VALIDATE_NEGATIVE_NUMBER) {
            return false;
        }
        return true;
    }
}
