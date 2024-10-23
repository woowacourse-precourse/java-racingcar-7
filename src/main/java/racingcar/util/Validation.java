package racingcar.util;

public class Validation {

    public static boolean isMoreFour() {
        int randomNumber = RandomNumber.generateRandomNumber();
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }
}
