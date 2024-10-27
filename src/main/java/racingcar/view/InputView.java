package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.ErrorMessage;

public class InputView {
    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public String inputCarNames() {
        outputView.printInputCarNamesMessage();
        return Console.readLine();
    }

    public int inputAttempts() {
        outputView.printInputAttemptsMessage();
        String attempts = Console.readLine();

        try {
            return Integer.parseInt(attempts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ATTEMPTS_TYPE_NUMBER.getMessage());
        }
    }
}
