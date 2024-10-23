package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.global.Message.ENTER_CAR_NAMES;
import static racingcar.global.Message.ENTER_TRY_COUNT;

public class InputView {

    public String getCarName() {
        System.out.println(ENTER_CAR_NAMES.getMessage());
        return readLine();
    }

    public int getTryCounts() {
        System.out.println(ENTER_TRY_COUNT.getMessage());
        return Integer.parseInt(readLine());
    }
}
