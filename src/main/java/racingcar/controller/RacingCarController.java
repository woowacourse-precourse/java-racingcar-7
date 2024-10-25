package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.ViewMessage;
import racingcar.domain.Car;
import racingcar.domain.ForwardCount;
import racingcar.domain.Input;
import racingcar.view.InputView;

public class RacingCarController {

    public void run() {
        inputCarNames();
        inputForwardCount();
    }

    private void inputCarNames() {
        InputView.showInputPrompt(ViewMessage.CAR_NAME_INPUT_PROMPT);
        Car.from(Input.from(read()).getNames());
    }

    private void inputForwardCount() {
        InputView.showInputPrompt(ViewMessage.FORWARD_COUNT_INPUT_PROMPT);
        ForwardCount.from(read());
    }

    public static String read() {
        return Console.readLine();
    }

}