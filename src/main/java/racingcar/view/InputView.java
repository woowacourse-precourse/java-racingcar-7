package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CarNameValidator;
import racingcar.validator.NumberOfTurnValidator;

public class InputView {
    private final CarNameValidator carNameValidator;
    private final NumberOfTurnValidator numberOfTurnValidator;

    public InputView(CarNameValidator carNameValidator, NumberOfTurnValidator numberOfTurnValidator) {
        this.carNameValidator = new CarNameValidator();
        this.numberOfTurnValidator = new NumberOfTurnValidator();
    }

    public String inputCarNames() {
        String input = Console.readLine();
        carNameValidator.validateCarNamesInput(input);
        return input;
    }

    public String inputNumberOfTurn() {
        String input = Console.readLine();
        numberOfTurnValidator.validateNumberOfTurn(input);
        return input;
    }



}
