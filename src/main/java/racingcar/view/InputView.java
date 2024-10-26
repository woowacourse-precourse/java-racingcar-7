package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String[] getCarNames() {
        String carNames =  Console.readLine();
        return carNames.split(",");
    }

    public static Integer getMovementCount() {
        return Integer.parseInt(Console.readLine());
    }
}
