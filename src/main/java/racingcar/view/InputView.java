package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputCarNames() {
        System.out.println(ViewMessages.CAR_INPUT_MESSAGE.getMessage());

        return Console.readLine();
    }

    public static int inputTryCount() {
        System.out.println(ViewMessages.TRY_COUNT_INPUT_MESSAGE.getMessage());

        return Integer.parseInt(Console.readLine());
    }

    public static void closeStream() {
        Console.close();
    }
}
