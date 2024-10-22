package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Input;

public class InputView {
    public Input readRacingCarNames() {
        System.out.println(DisplayedMessage.INPUT_CARS_MESSAGE.getValue());
        String cars = Console.readLine();
        return new Input(cars);
    }

    public Input readRacingTryCount() {
        System.out.println(DisplayedMessage.INPUT_TRY_COUNT_MESSAGE.getValue());
        String count = Console.readLine();
        return new Input(count);
    }
}
