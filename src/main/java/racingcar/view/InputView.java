package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getCarName() {
        System.out.println(ConsoleMessage.ENTER_CAR_NAME);
        return Console.readLine();
    }

    public String getTryNumber() {
        System.out.println(ConsoleMessage.ENTER_TRY_NUMBER);
        return Console.readLine();
    }

    public void close() {
        Console.close();
    }
}
