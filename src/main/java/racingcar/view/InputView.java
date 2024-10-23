package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Car;

public class InputView {
    private final InputHandler inputHandler;

    public InputView(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void readCarNames() {
        String input = Console.readLine();
    }
}
