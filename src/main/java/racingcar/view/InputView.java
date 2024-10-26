package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String[] getCarNames() {
        String[] value = Console.readLine().split(",");

        return value;
    }

    public static String getRound() {
        String value = Console.readLine();
        return value;
    }


}
