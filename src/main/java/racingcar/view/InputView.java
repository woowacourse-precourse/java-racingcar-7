package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.AppConstants;
import racingcar.validator.InputValidator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public List<String> getCarNames() {
        String input = Console.readLine();
        InputValidator.checkDelimiter(input);

        List<String> carNames = Arrays.stream(input.split(AppConstants.DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());

        InputValidator.carNames(carNames);
        return carNames;
    }

    public int getNumberOfAttempts() {
        String input = Console.readLine();
        InputValidator.isNumeric(input);

        int attempts = convertToInt(input);
        InputValidator.attemptCount(attempts);
        return attempts;
    }

    private int convertToInt(String input) {
        return Integer.parseInt(input);
    }

    public void close() {
        Console.close();
    }
}