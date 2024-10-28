package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getCarsName() {
        return Console.readLine();
    }

    public int getTryingNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
