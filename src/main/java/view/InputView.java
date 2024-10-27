package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getCarNames() {
        OutputView.printGuide();
        String CarNames = Console.readLine();
        return CarNames;

    }

    public int getAttemptCount() {
        OutputView.printAttemptPrompt();
        return Integer.parseInt(Console.readLine());
    }

}



