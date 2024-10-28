package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

public class InputUtils {
    static final String delimiter = ",";
    public static String[] readCarNameInput() {
        String carNameInput = Console.readLine();
        Validator.validateWhitespaceInput(carNameInput);
        Validator.validateNullInput(carNameInput);
        return parseCarNames(carNameInput);
    }

    public static int readRaceCountInput() {
        String raceCountInput = Console.readLine();
        Validator.validateWhitespaceInput(raceCountInput);
        Validator.validateNullInput(raceCountInput);
        return Validator.validatePositiveNumber(raceCountInput);
    }

    private static String[] parseCarNames(String carNameInput) {
        Validator.validateRightDelimiter(carNameInput);
        String[] carNames = carNameInput.split(delimiter);
        if (carNames.length == 0) {
            throw new IllegalArgumentException("하나 이상의 이름을 입력해야합니다.");
        }
        for (String carName : carNames) {
            Validator.validateCarName(carName);
        }
        Validator.validateUniqueCarName(carNames);
        return carNames;
    }
}
