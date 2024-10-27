package racingcar.view;

import static racingcar.message.InfoMessages.INPUT_CAR_NAMES;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readCarNames() {
        System.out.println(INPUT_CAR_NAMES);
        return Console.readLine();
    }
}
