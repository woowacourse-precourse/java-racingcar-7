package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Constants.ViewMessage;

public class InputView {

    public String requestCarNames() {
        System.out.println(ViewMessage.REQUEST_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    public String requestRound() {
        System.out.println(ViewMessage.REQUEST_ROUNDS_MESSAGE);
        return Console.readLine();
    }

}
