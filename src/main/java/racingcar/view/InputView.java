package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.utils.Constant;
import racingcar.utils.InputValidator;

public class InputView {
    private final InputValidator inputValidator = new InputValidator();

    public List<String> getCarNames() {
        System.out.println(Constant.CAR_NAME_INPUT_MESSAGE);
        String userInput = Console.readLine();

        return inputValidator.validateCarNames(userInput);
    }

    public int getAttemptCount() {
        System.out.println(Constant.ATTEMPT_COUNT_INPUT_MESSAGE);
        String userInput = Console.readLine();

        return inputValidator.validateAttemptCount(userInput);
    }
}
