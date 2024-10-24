package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.CarNameValidator;
import racingcar.validation.TryCountValidator;

public class InputView {

    public static String inputCarName() {
        String input = Console.readLine();
        CarNameValidator.validate(input);
        CarNameValidator.validateCar(input);
        return input;
    }

    public static String inputTryCount() {
        String input = Console.readLine();
        TryCountValidator.validate(input);
        return input;
    }
}
