package racingcar.model;

import racingcar.exception.ExceptionCode;


public class CarNameDelimiter {

    private final static String DELIMITER = ",";
    private String[] carNames;


    public String[] NameDelimiter(String name) {
        carNames = name.trim().split("\\s*" + DELIMITER + "\\s*");

        return carNames;
    }

    public void validateDelimiter(String name) {
        if (name.matches(".*[^\\w\\s,가-힣].*")) {
            throw new IllegalArgumentException(String.valueOf(ExceptionCode.INVALID_DELIMITER));
        }
    }

}
