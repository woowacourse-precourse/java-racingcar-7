package racingcar.model;

import racingcar.exception.ExceptionCode;

import static racingcar.model.Number.MAX_NAME_LENGTH;


public class CarNameDelimiter {

    private final static String DELIMITER = ",";
    private String[] carNames;


    public String[] NameDelimiter(String name) {
        validateDelimiter(name);
        carNames = name.trim().split("\\s*" + DELIMITER + "\\s*");
        checkValidAll(carNames);

        return carNames;
    }

    public void checkValidAll(String[] validCarName) {
        validStringLength(validCarName);
        for (String name : validCarName) {
            validCarNameNull(name);
            validCarNameLength(name);
        }
    }


    public void validateDelimiter(String name) {
        if (name.matches(".*[^\\w\\s,가-힣].*")) {
            throw new IllegalArgumentException(String.valueOf(ExceptionCode.INVALID_DELIMITER));
        }
    }

    //, , , 이런식으로 들어와도 예외 처리(공백이 들어오면 처리해준다)
    public void validStringLength(String[] validCarName) {
        if (validCarName.length == 0) {
            throw new IllegalArgumentException(ExceptionCode.NAME_LIST_NULL.getMessage());
        }
    }


    //, , pobi 에서 자동차 이름 배열에 공백문자열이 있으면 예외처리 해준다. (문자열 분리 후 size가 0이면 예외처리)
    public void validCarNameNull(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionCode.NAME_NULL.getMessage());
        }
    }

    public void validCarNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionCode.NAME_SIZE_OVER.getMessage());
        }
    }


}
