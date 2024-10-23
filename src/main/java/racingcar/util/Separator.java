package racingcar.util;

public class Separator {

    private static final String DEFAULT_DELIMITER  = ",";

    public String[] splitWithComma(String str) {
        return str.split(DEFAULT_DELIMITER);
    }
}
