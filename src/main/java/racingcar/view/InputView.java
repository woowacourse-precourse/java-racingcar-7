package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.InputMessage;

public class InputView {
    public String inputCarNames() {
        InputMessage.CAR_NAMES.printMessage();
        return Console.readLine();
    }

    public String inputRaceRounds() {
        InputMessage.RACE_ROUNDS.printMessage();
        return Console.readLine();
    }
}
