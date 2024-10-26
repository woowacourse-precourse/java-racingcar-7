package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    private static final String NAME_DELIMITER = ",";
    private static final String ERROR_EMPTY_CAR_NAME = "자동차 이름이 아무것도 들어오지 않았습니다.";
    private static final String ERROR_CAR_NAME_TOO_LONG = "자동차 이름의 길이가 5를 초과하였습니다.";
    private static final String ERROR_INVALID_TRY_COUNT = "알맞지 않은 시도 횟수 값이 들어왔습니다.";
    private final List<String> carNames;
    private final int tryCount;

    public InputParser(String carNamesInput, String tryCountInput) {
        carNames = new ArrayList<>();
        parseCarNames(carNamesInput);
        tryCount = parseTryCount(tryCountInput);
    }

    private void parseCarNames(String carNamesInput){
        validateCarNamesNotEmpty(carNamesInput);
        for (String carName : carNamesInput.split(NAME_DELIMITER)) {
            validateLength(carName);
            carNames.add(carName);
        }
    }

    private int parseTryCount(String tryCountInput) {
        try {
            int parseIntValue = Integer.parseInt(tryCountInput);
            validateInteger(parseIntValue);
            return parseIntValue;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_TRY_COUNT);
        }
    }

    private void validateCarNamesNotEmpty(String carNamesInput) {
        if(carNamesInput.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_CAR_NAME);
        }
    }

    private void validateLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_TOO_LONG);
        }
    }

    private void validateInteger(int parseIntValue) {
        if (parseIntValue <= 0) {
            throw new NumberFormatException();
        }
    }

    public List<String> getCarNameList() {
        return carNames;
    }

    public int getTryCount(){
        return tryCount;
    }
}
