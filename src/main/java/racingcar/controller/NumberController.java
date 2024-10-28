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
        if (Integer.parseInt(number) > 0) {
            return true;
        }
        return false;
    }
}
