package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.utils.Constant;

public class InputView {

    public List<String> getCarNames() {
        System.out.println(Constant.CAR_NAME_INPUT_MESSAGE);
        String inputString = Console.readLine();
    }

    public int getAttemptCount() {
        System.out.println(Constant.ATTEMPT_COUNT_INPUT_MESSAGE);
        String inputString = Console.readLine();
    }
}
