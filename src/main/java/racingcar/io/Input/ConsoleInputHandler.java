package racingcar.io.Input;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputHandler implements InputHandler {

    @Override
    public String inputCarNameList() {
        return Console.readLine();
    }

    @Override
    public int inputRoundNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
