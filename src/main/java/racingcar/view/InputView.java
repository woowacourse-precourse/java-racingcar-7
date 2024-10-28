package racingcar.view;

import static racingcar.constant.RacingCarInfoMsg.TYPE_CAR_NAMES;
import static racingcar.constant.RacingCarInfoMsg.TYPE_RACE_COUNT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputCarNames() {
        System.out.println(TYPE_CAR_NAMES.getMsg());
        return Console.readLine();
    }

    public String inputRaceCount() {
        System.out.println(TYPE_RACE_COUNT.getMsg());
        return Console.readLine();
    }
}
