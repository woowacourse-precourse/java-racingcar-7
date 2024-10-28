package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Constant;
import racingcar.util.InputUtils;

public class InputHandler {
    public List<Car> getCarNames() {
        System.out.println(Constant.CAR_NAME_INPUT_MESSAGE);
        String input = Console.readLine();
        return InputUtils.createCarListFromInput(input);
    }

    public int getAttemptCount() {
        System.out.println(Constant.ATTEMPT_INPUT_MESSAGE);
        String input = Console.readLine();
        return InputUtils.getAttemptCountFromInput(input);
    }
}
