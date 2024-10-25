package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Car;

public class InputView {
    private final InputHandler inputHandler;

    public InputView(final InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public List<Car> readCarNames() {
        final String input = Console.readLine();
        inputHandler.checkEmpty(input);
        return inputHandler.validateUniqueNames(input);
    }
}
