package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String printInputMessage(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
