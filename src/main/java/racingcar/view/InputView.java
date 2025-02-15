package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readRacingTryCount() {
        final String tryCount = Console.readLine();
        return Integer.parseInt(tryCount);
    }

}
