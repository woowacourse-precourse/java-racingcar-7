package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.NullEmptyStringException;
import racingcar.message.IOMessage;

public class InputManager implements IOManager {
    private static final InputManager inputManager = new InputManager();

    private InputManager() {
    }

    public static InputManager getInstance() {
        return inputManager;
    }

    private static String validateInput(final String input) {
        if (input == null || input.isBlank()) {
            throw new NullEmptyStringException();
        }
        return input;
    }

    public String carNameInput() {
        printMessage(IOMessage.ENTER_CAR_NAME_INPUT);
        return validateInput(Console.readLine());
    }

    public String attemptCountInput() {
        printMessage(IOMessage.ENTER_ATTEMPT_COUNT_INPUT);
        return validateInput(Console.readLine());
    }
}
