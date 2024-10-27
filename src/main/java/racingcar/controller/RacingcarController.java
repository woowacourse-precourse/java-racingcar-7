package racingcar.controller;

import racingcar.io.Input;
import racingcar.io.Output;
import racingcar.model.Racingcar;
import racingcar.service.RacingcarService;
import racingcar.util.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class RacingcarController {
    private final Output output;
    private final Input input;
    private final Validator validator;
    private final RacingcarService racingcarService;

    public RacingcarController(Output output, Input input, Validator validator, RacingcarService racingcarService) {
        this.output = output;
        this.input = input;
        this.validator = validator;
        this.racingcarService = racingcarService;
    }

    public void playRacingcarGame() {
        output.printCarNameInputPrompt();
        String carName = input.inputString();

        List<String> carNameList = validateCarName(carName);
        List<Racingcar> racingcars = createRacingcars(carNameList);

        output.printCountInputPrompt();
        String countString = input.inputString();

        final int count = validateCount(countString);

        output.printRaceResultPrompt();

        for (int i = 0; i < count; i++) {
            racingcarService.startRaceByCount(racingcars);
            output.printResultsByCount(racingcars);
        }

        output.printWinnerPrompt();
        racingcarService.determineWinner(racingcars);
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

    private List<Racingcar> createRacingcars(List<String> carNameList) {
        return carNameList.stream()
                .map(Racingcar::new)
                .collect(Collectors.toList());
    }

    private int validateCount(String countString) {
        validator.validateEmptyString(countString);
        validator.validateCountContainsSpace(countString);
        int countInt = validator.validateCountNonInteger(countString);
        validator.validateCountPositiveIntegerAboveOne(countInt);

        return countInt;
    }
}
