package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getCarNames() {
        OutputView.printGuide();
        return Console.readLine();

    }

    public String getAttemptCount() {
        OutputView.printAttemptPrompt();
        return Console.readLine();
    }

}



