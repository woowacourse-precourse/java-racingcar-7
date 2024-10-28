package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

public class InputUtils {
    static final String delimiter = ",";

    public static String readInput() {
        String input = Console.readLine();
        Validator.validateWhitespaceInput(input);
        Validator.validateNullInput(input);
        return input;
    }

    public static String[] parseCarNameInput(String input) {
        return parseCarNames(input);
    }

    public static int parseRaceCountInput(String input) {
        return Validator.validatePositiveNumber(input);
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
