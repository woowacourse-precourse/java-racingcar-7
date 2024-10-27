package racingcar.handler;

import static racingcar.constants.Constraints.CAR_NAME_DELIMITER;
import static racingcar.constants.ErrorMessages.NUMBER_FORMAT_ERROR_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.validator.InputValidator;

public class InputHandler {
    public static List<String> requestCarNames() {
        String carNamesText = Console.readLine();
        List<String> carNames = extractCarNamesToList(carNamesText);
        InputValidator.validateCarNames(carNames);
        return carNames;
    }

    private static List<String> extractCarNamesToList(String carNamesText) {
        List<String> carNames = Arrays.stream(carNamesText.split(CAR_NAME_DELIMITER)).
                map(String::trim).
                toList();
        return carNames;
    }

    public static int requestTotalRounds() {
        return convertTotalRoundToInt(Console.readLine());
    }

    private static int convertTotalRoundToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }
}
