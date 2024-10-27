package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

import static racingcar.message.ViewMessage.CAR_NAMES_MESSAGE;
import static racingcar.message.ViewMessage.TRY_NUMBER_MESSAGE;

public class InputView {

    public static String inputCarNames() {
        System.out.println(CAR_NAMES_MESSAGE);
        return Console.readLine().trim();
    }

    public static String inputTryNumber() {
        System.out.println(TRY_NUMBER_MESSAGE);
        return Console.readLine().trim();
    }
}