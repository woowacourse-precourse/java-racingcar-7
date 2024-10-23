package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.TextString.NAME_SEPARATOR;

public class ReadUserInputView {
    public String[] readCarNames() {
        var carNames = readLine().split(NAME_SEPARATOR.getValue());
        if (!UserInputValidator.isValidCarName(carNames)) {
            throw new IllegalArgumentException();
        }
        return carNames;
    }

    public int readTryCount() {
        var tryCount = readLine();
        if (!UserInputValidator.isValidTryCount(tryCount)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(tryCount);
    }
}
