package racingcar.io.Input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exceptions.InvalidRoundValueException;

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
            throw new InvalidRoundValueException("라운드 수가 올바르게 입력되지 않았습니다.");
        }
    }
}
