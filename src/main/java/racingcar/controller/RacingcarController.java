package racingcar.controller;

import racingcar.io.Input;
import racingcar.io.Output;
import racingcar.util.Validator;

import java.util.List;

public class RacingcarController {
    private final Output output;
    private final Input input;
    private final Validator validator;

    public RacingcarController(Output output, Input input, Validator validator) {
        this.output = output;
        this.input = input;
        this.validator = validator;
    }

    public void playRacingcarGame() {
        output.printCarNameInputPrompt();
        String carName = input.inputString();

        List<String> carNameList = validateCarName(carName);
    }

    private List<String> validateCarName(String carName) {
        validator.validateEmptyString(carName);

        List<String> carNameList = input.splitInput(carName);
        validator.validateStringLength(carNameList);
        validator.validateDuplicateName(carNameList);
        validator.validateNameCharacters(carNameList);
        validator.validateContainSpaceName(carNameList);
        validator.validateNameCharacters(carNameList);

        return carNameList;
    }
}
