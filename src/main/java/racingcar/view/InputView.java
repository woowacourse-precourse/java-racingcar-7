package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.CarNameValidator;

public class InputView {

    public static String inputCarName() {
        String input = Console.readLine();
        CarNameValidator.validate(input);
        CarNameValidator.validateCar(input);
        return input;
    }
}
