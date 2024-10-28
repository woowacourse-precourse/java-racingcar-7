package racingcar.utils;

public class Parser {
    public static String[] parseName(String inputString) {
        return inputString.split(",", -1);
    }
}
