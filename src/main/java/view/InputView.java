package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String printSetCarMessage() {
        System.out.println(SystemMessage.SET_CAR_NAME_MESSAGE.print());
        return Console.readLine();
    }

    public static String printGetTryNumberMessage() {
        System.out.println(SystemMessage.GET_TRY_NUMBER_MESSAGE.print());
        return Console.readLine();
    }
}
