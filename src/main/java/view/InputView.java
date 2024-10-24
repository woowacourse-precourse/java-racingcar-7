package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String pringSetCarMesasge() {
        System.out.println(SystemMessage.GET_CAR_NAME_MESSAGE.print());
        return Console.readLine();
    }

    public static String pringGetTryNumberMessage() {
        System.out.println(SystemMessage.GET_TRY_NUMBER_MESSAGE.print());
        return Console.readLine();
    }
}
