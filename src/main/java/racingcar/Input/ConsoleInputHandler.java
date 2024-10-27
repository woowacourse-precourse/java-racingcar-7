package racingcar.Input;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputHandler implements InputHandler {

    @Override
    public String inputCarNameList() {
        return Console.readLine();
    }

    @Override
    public int inputRoundNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
