package racingcar.utility;

public class Calculator {

    private static final int boundNumber = 4;

    public static boolean canMove(int randomNumber) {
        return randomNumber >= boundNumber;
    }
}
