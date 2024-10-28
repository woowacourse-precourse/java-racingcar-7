package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.exception.InputValidation;
import racingcar.util.Convertor;

public class InputView {

    private static final String CAR_NAME_DELIMITER = ",";

    public List<String> inputCarNames() {
        String carNames = Console.readLine();
        InputValidation.validateCarNames(carNames);

        String[] splitCarNames = carNameSplit(carNames);
        InputValidation.validateDelimiter(splitCarNames);

        return Convertor.toList(splitCarNames);
    }

    public int inputTryCount() {
        String tryCount = Console.readLine();
        InputValidation.validateTryCount(tryCount);

        return Convertor.toInt(tryCount);
    }

    private String[] carNameSplit(String carNames) {
        return carNames.split(CAR_NAME_DELIMITER);
    }
}
