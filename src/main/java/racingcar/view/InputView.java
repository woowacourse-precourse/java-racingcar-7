package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static Object[] racingcarInputView() {
        String inputName=Console.readLine();

        String moveCount = Console.readLine();
        return new Object[]{inputName, moveCount};
    }
}
