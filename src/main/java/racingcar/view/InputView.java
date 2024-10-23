package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.exception.InputValidation;
import racingcar.util.Convertor;

public class InputView {

    public List<String> inputCarNames() {
        String carNames = Console.readLine();

        validateCarNames(carNames);

        String[] splitCarNames = carNameSplit(carNames);
        return Convertor.toList(splitCarNames);
    }

    public int inputRacingCount() {
        String racingCount = Console.readLine();

        return Integer.parseInt(racingCount);
    }

    private void validateCarNames(String carNames) {
        InputValidation inputValidation = new InputValidation();

        inputValidation.validateNullOrEmpty(carNames);
        inputValidation.validateBlank(carNames);
    }

    private String[] carNameSplit(String carNames) {
        return carNames.split(",");
    }
}
