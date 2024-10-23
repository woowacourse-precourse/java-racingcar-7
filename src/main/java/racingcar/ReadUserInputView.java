package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.TextString.NAME_SEPARATOR;

public class ReadUserInputView {
    public String[] readCarNames() {
        var carNames = readLine().split(NAME_SEPARATOR.getValue());
        return carNames;
    }

    public int readTryCount() {
        var carNames = readLine();
        return Integer.parseInt(carNames);
    }
}
