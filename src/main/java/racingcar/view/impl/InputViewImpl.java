package racingcar.view.impl;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.Message;
import racingcar.view.InputView;

public class InputViewImpl implements InputView {
    public String readCarNames() {
        System.out.println(Message.PROMPT_CAR_NAMES);
        return Console.readLine();
    }

    public String readRound() {
        System.out.println(Message.PROMPT_ROUND_COUNT);
        return Console.readLine();
    }
}