package racingcar.controller;

public class NumberController {

    public static boolean isInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isNaturalNumber(String number) {
        return Integer.parseInt(number) > 0;
    }
}
