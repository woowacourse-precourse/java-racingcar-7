package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getCarsName() {
        return Console.readLine();
    }

    public int getAttemptCount() {
        return Integer.parseInt(Console.readLine());
    }
}
