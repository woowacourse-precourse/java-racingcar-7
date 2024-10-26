package racingcar.manager;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

public class InputManager {

    public String inputCarName() {
        String input = Console.readLine();
        InputValidator validator = new InputValidator();
        validator.validateNameInput(input);
        return input;
    }
}
