package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getCarNames() {
        return Console.readLine();
    }

    public String getNumberOfTrials() {
        return Console.readLine();
    }
}