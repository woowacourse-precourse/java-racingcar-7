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
        printMessage(IOMessage.Enter_Car_Name_INPUT);
        return Console.readLine();
    }
}
