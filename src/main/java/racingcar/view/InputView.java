package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getCarName() {
        return Console.readLine();
    }

    public static Integer getMovementCount() {
        return Integer.parseInt(Console.readLine());
    }
}
