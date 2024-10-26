package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getCarNames() {
        String CarNames = Console.readLine();
        return CarNames;

    }

    public int getAttemptCount() {
        return Integer.parseInt(Console.readLine());
    }

}



