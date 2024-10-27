package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

import static racingcar.message.ViewMessage.CAR_NAMES_MESSAGE;
import static racingcar.message.ViewMessage.TRY_NUMBER_MESSAGE;

public class InputView {

    public static String inputCarNames() {
        System.out.println(CAR_NAMES_MESSAGE);
        String input = Console.readLine().trim();

        InputValidator.validateEmpty(input);
        InputValidator.validateCharacter(input);

        return input;
    }

    public static int inputTryNumber() {
        System.out.println(TRY_NUMBER_MESSAGE);
        String tryNumber = Console.readLine().trim();

        InputValidator.validateInteger(tryNumber);

        return Integer.parseInt(tryNumber);
    }
}