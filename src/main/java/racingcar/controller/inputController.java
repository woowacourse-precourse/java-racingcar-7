package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.InputContainer;

public class inputController {

    public InputContainer readConsole() {
        String inputCarNames = Console.readLine();
        int attempts = Integer.parseInt(Console.readLine());
        Console.close();

        return new InputContainer(inputCarNames, attempts);
    }
}
