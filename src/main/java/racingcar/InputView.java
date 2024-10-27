package racingcar;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.List;

public class InputView {
    private final String CAR_NAME_DELIMITER = ",";

    public List<String> inputCarNames() {
        String carNames = readLine();
        return parseCarNames(carNames);
    }

    public int inputRoundCount() {
        return Integer.parseInt(readLine());
    }

    private List<String> parseCarNames(String carNames) {
        return List.of(carNames.split(CAR_NAME_DELIMITER));
    }
}
