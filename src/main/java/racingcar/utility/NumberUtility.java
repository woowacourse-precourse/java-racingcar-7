package racingcar.utility;

public class NumberUtility {

    private final static String NUMBER_REGEX = "^[0-9]+(\\\\.[0-9]+)?$";

    public static boolean isNumberStr(String input){
        return input.matches(NUMBER_REGEX);
    }

    public static boolean isPositiveNumber(int moveCount) {
        return moveCount >= 0;
    }

    public static int getNumber(String moveCount) {
        return Integer.parseInt(moveCount);
    }

}
