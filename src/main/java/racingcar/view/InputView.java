package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.InputValidator;
import racingcar.parser.InputParser;
import java.util.List;

public class InputView {
    private final InputValidator inputValidator;
    private final InputParser inputParser;

    public InputView() {
        this.inputValidator = new InputValidator();
        this.inputParser = new InputParser();
    }

    public List<String> getCarNames() {
        String input = Console.readLine();
        inputValidator.checkDelimiter(input);

        List<String> carNames = inputParser.convertToCarNamesList(input);
        inputValidator.carNames(carNames);
        return carNames;
    }

    public int getNumberOfAttempts() {
        String input = Console.readLine();
        inputValidator.isNumeric(input);

        int attempts = inputParser.convertToInt(input);
        inputValidator.attemptCount(attempts);
        return attempts;
    }

    public void close() {
        Console.close();
    }
}