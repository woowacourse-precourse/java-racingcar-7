package view;

import camp.nextstep.edu.missionutils.Console;
import constant.Prompt;

public class InputView {
    private InputView() {}

    public static String inputCars() {
        System.out.println(Prompt.INPUT_CAR_NAMES.getMessage());
        return Console.readLine();
    }

    public static String inputAttempt() {
        System.out.println(Prompt.INPUT_ATTEMPT_COUNT.getMessage());
        return Console.readLine();
    }
}
