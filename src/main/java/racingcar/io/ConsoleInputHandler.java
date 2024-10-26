package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputStringValidator;

public class ConsoleInputHandler {
    public String getUserInputCarNameString() {
        String userInputCarNameString = Console.readLine();
        InputStringValidator.carNameIsEmpty(userInputCarNameString);
        return userInputCarNameString;
    }

}
