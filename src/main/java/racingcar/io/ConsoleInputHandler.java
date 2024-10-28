package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputHandler implements InputHandler {

    @Override
    public String getCarNames() {
        return Console.readLine();
    }

    @Override
    public int getAttemptCount() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 입력 형식입니다.");
        }
    }
}
