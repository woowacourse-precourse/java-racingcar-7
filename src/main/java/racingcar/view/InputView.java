package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputCarNames() {
        System.out.println("Enter names of cars:");
        return Console.readLine();
    }

    public String inputAttemptCount() {
        System.out.println("Enter number of attempts:");
        return Console.readLine();
    }
}
