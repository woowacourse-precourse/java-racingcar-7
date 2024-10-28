package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputCar() {
        System.out.println(Message.START);
        return Console.readLine();
    }

    public static String inputCount() {
        System.out.println(Message.COUNT);
        return Console.readLine();
    }
}
