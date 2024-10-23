package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.InputValidation;

public class InputView {

    public String inputCarNames() {
        String carNames = Console.readLine();

        validateCarNames(carNames);

        return carNames;
    }

    private void validateCarNames(String carNames) {
        InputValidation inputValidation = new InputValidation();

        inputValidation.validateNullOrEmpty(carNames);
        inputValidation.validateBlank(carNames);
    }
}
