package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.error.GameError.*;

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
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT.getMessage());
        }
    }
}
