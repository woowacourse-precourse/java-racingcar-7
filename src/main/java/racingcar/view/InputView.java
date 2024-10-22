package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Input;

public class InputView {
    public Input readRacingCarNames() {
        System.out.println(DisplayedMessage.INPUT_CARS_MESSAGE);
        String cars = Console.readLine();
        return new Input(cars);
    }
}
