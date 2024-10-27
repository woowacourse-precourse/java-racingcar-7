package racingcar.service;

import racingcar.parser.InputParser;
import racingcar.validation.InputValidator;

public class RacingCarService {

    private final InputValidator inputValidator;
    private final InputParser inputParser;

    public RacingCarService() {
        this.inputValidator = new InputValidator();
        this.inputParser = new InputParser();
    }

    public void checkCarNamesInput(String input) {
        inputValidator.validateInputIsEmpty(input);

        String[] carNames = inputParser.splitInput(input);
        for (String carName : carNames) {
            inputValidator.validateCarName(carName);
        }
    }

    public void checkTryCountInput(String input) {
        inputValidator.validateInputIsEmpty(input);

        inputValidator.validateTryCount(input);
    }
}