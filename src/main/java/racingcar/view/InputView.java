package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.InputContainer;

public class InputView {

    public InputContainer readConsole() {
        String inputCarNames = Console.readLine();
        int attempts = Integer.parseInt(Console.readLine());
        Console.close();

        return new InputContainer(inputCarNames, attempts);
    }
}
