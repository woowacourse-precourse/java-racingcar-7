package racingcar;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.List;

public class InputView {
    private final InputValidator inputValidator;
    private final String CAR_NAME_DELIMITER = ",";

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public List<String> inputCarNames() {
        String carNames = readLine();
        List<String> carNameList = parseCarNames(carNames);
        inputValidator.validateCarNames(carNameList);
        return carNameList;
    }

    public int inputRoundCount() {
        String input = readLine();
        return inputValidator.validateRoundCount(input);
    }

    private List<String> parseCarNames(String carNames) {
        return List.of(carNames.split(CAR_NAME_DELIMITER));
    }
}
