package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.IOMessage;

public class InputManager implements IOManager {
    private static final InputManager inputManager = new InputManager();

    private InputManager() {
    }

    public static InputManager getInstance() {
        return inputManager;
    }

    public String carNameInput() {
        printMessage(IOMessage.ENTER_CAR_NAME_INPUT);
        return Console.readLine();
    }

    public String attemptCountInput() {
        printMessage(IOMessage.ENTER_ATTEMPT_COUNT_INPUT);
        return Console.readLine();
    }
}
