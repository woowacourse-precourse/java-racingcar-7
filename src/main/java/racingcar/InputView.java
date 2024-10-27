package racingcar;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {
    public String inputCarNames() {
        return readLine();
    }

    public int inputRoundCount() {
        return Integer.parseInt(readLine());
    }
}
