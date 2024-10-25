package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.enums.ViewMessage;

public class InputView {

    public String promptCarNames() {
        System.out.println(ViewMessage.PROMPT_CAR_NAMES.getMessage());
        return Console.readLine();
    }

    public String promptRounds() {
        System.out.println(ViewMessage.PROMPT_ROUNDS.getMessage());
        return Console.readLine();
    }
}
