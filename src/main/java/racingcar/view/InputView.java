package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.exception.InputValidation;
import racingcar.util.Convertor;

public class InputView {

    public List<String> inputCarNames() {
        String carNames = Console.readLine();
        InputValidation.validateCarNames(carNames);

        String[] splitCarNames = carNameSplit(carNames);
        InputValidation.validateDelimiter(splitCarNames);

        return Convertor.toList(splitCarNames);
    }

    public int inputRacingCount() {
        String racingCount = Console.readLine();
        InputValidation.validateRacingCount(racingCount);

        return Convertor.toInt(racingCount);
    }

    private String[] carNameSplit(String carNames) {
        return carNames.split(",");
    }
}
