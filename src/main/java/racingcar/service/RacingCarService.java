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

    public void settingRacingCars(String carNameInput) {
        inputValidator.validateInputIsEmpty(carNameInput);

        String[] carNames = inputParser.splitInput(carNameInput);
        for (String carName : carNames) {
            racingCarModel.add(carName);
        }
        racingCarModel.checkSavedCars();
    }

    public void racingStart(String tryCountInput) {
        inputValidator.validateInputIsEmpty(tryCountInput);
        inputValidator.validateTryCount(tryCountInput);

        int tryCount = inputParser.parseInt(tryCountInput);
        for (int i = 0; i < tryCount; i++) {
            round();
        }
    }

    private void round() {
    }
}