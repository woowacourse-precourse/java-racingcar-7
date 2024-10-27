package racingcar.service;

import racingcar.model.RacingCarModel;
import racingcar.parser.InputParser;
import racingcar.validation.InputValidator;

public class RacingCarService {

    private final InputValidator inputValidator;
    private final InputParser inputParser;
    private final RacingCarModel racingCarModel;

    public RacingCarService() {
        this.inputValidator = new InputValidator();
        this.inputParser = new InputParser();
        this.racingCarModel = new RacingCarModel();
    }

    public void checkTryCountInput(String input) {
        inputValidator.validateInputIsEmpty(input);

        inputValidator.validateTryCount(input);
    }

    public void settingRacingCars(String carNameInput) {
        inputValidator.validateInputIsEmpty(carNameInput);

        String[] carNames = inputParser.splitInput(carNameInput);
        for (String carName : carNames) {
            racingCarModel.add(carName);
        }
        racingCarModel.checkSavedCars();
    }
}