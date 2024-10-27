package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validate.InputNumberValidation;
import racingcar.view.enums.ViewMessages;

public class InputView {
    public static String enterCarNames() {
        System.out.println(ViewMessages.ENTER_CAR_NAMES.getViewMessages());
        return Console.readLine();
    }

    public static String enterNumberOfAttempts() {
        System.out.println(ViewMessages.ENTER_NUMBER_OF_ATTEMPTS.getViewMessages());
        String inputNumber = Console.readLine();
        InputNumberValidation.validateInputNumber(inputNumber);
        return inputNumber;
    }
}
