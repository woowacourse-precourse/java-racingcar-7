package racingcar.view;


import static racingcar.common.Constants.GET_CAR_NAMES_PROMPT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getCarNames () {
        System.out.println(GET_CAR_NAMES_PROMPT);
        return Console.readLine();
    }
}
