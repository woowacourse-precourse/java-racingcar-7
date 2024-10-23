package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.InputValidation;

public class InputView {

    public String inputCarNames() {
        String input = Console.readLine();

        validateInput(input);

        return input;
    }

    private void validateInput(String input) {
        InputValidation inputValidation = new InputValidation();

        inputValidation.validateNullOrEmpty(input);
        inputValidation.validateBlank(input);
    }
}
