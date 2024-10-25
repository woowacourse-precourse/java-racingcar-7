package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputStringValidator;

public class ConsoleInputHandler {
    public String getUserInput() {
        String userInputString = Console.readLine();
        InputStringValidator.isEmpty(userInputString);
        return userInputString;
    }
}
