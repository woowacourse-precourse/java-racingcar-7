package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.util.constant.OutputMessageConstant.INPUT_CAR_NAME;
import static racingcar.util.constant.OutputMessageConstant.INPUT_TURN_COUNT;

public class InputView {

    public String input() {
        return Console.readLine();
    }

    private void registerExecutionNumberMessage() {
        System.out.println(INPUT_TURN_COUNT.getMessage());
    }

    private void registerCarMessage() {
        System.out.println(INPUT_CAR_NAME.getMessage());
    }

    public String registerCarInputView() {
        registerCarMessage();
        return input();
    }

    public String registerExecutionNumberInputView() {
        registerExecutionNumberMessage();
        return input();
    }
}
