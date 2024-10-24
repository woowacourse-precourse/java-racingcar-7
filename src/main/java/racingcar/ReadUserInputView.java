package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.TextString.NAME_SEPARATOR;

public class ReadUserInputView {
    public String[] readRacingCarNames() {
        var carNames = readLine().split(NAME_SEPARATOR.getValue());
        if (!UserInputValidator.isValidRacingCarName(carNames)) {
            throw new IllegalArgumentException();
        }
        return carNames;
    }

    public long readTryCount() {
        var tryCount = readLine();
        if (!UserInputValidator.isValidTryCount(tryCount)) {
            throw new IllegalArgumentException();
        }
        return Long.parseLong(tryCount);
    }
}
