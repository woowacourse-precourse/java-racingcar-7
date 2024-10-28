package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.InputView;

public class InputViewController {
    private InputView inputView = new InputView();

    public String getName() {
        inputView.printInputCarNameMessage();
        return Console.readLine();
    }

    public String getTrial() {
        inputView.printInputTrialMessage();
        return Console.readLine();
    }
}
