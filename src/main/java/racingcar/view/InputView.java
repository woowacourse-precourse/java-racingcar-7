package racingcar.view;

import static racingcar.constans.ViewMessage.CAR_NAME_INPUT_PROMPT;
import static racingcar.constans.ViewMessage.TRY_COUNT_INPUT_PROMPT;

public class InputView {

    public static void showCarNameInputPrompt() {
        System.out.println(CAR_NAME_INPUT_PROMPT.getMessage());
    }

    public static void showTryCountInputPrompt() {
        System.out.println(TRY_COUNT_INPUT_PROMPT.getMessage());
    }

}