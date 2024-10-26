package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.RacingCarInput;
import racingcar.exception.NullEmptyStringException;
import racingcar.model.attemptcountinput.AttemptCountValidation;
import racingcar.model.carnameinput.CarNameSplit;
import racingcar.model.carnameinput.CarNameValidation;

public class InputManager {
    private static final InputManager inputManager = new InputManager();

    private InputManager() {
    }

    public static InputManager getInstance() {
        return inputManager;
    }

    public RacingCarInput createRacingCarInput() {
        String carName = carNameInput();
        String[] carNameArray = CarNameSplit.nameSplit(carName);
        CarNameValidation.carNameValidate(carNameArray);

        String attemptCount = attemptCountInput();
        int attemptCountNumber = AttemptCountValidation.attemptCountValidation(attemptCount);

        return new RacingCarInput(carNameArray, attemptCountNumber);
    }

    private static String validateInput(final String input) {
        if (input == null || input.isBlank()) {
            throw new NullEmptyStringException();
        }
        return input;
    }

    public String carNameInput() {
        OutputManager.printEnterCarNameMessage();
        return validateInput(Console.readLine());
    }

    public String attemptCountInput() {
        OutputManager.printEnterAttemptCountMessage();
        return validateInput(Console.readLine());
    }
}
