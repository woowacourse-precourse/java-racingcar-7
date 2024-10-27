package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.InvalidInputException;

public class InputView {
    private static final InputView inputView = new InputView();
    private final OutputView outputView;

    private InputView() {
        outputView = OutputView.getInstance();
    }

    public static InputView getInstance() {
        return inputView;
    }

    public String getCarName() {
        outputView.getCarName();
        String input = Console.readLine();
        InvalidInputException.validateInput(input);
        return input;
    }

    public String getAttemptCount() {
        outputView.getAttemptCount();
        String input = Console.readLine();
        InvalidInputException.validateInput(input);
        return input;
    }

}
