package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static Object[] racingcarInputView() {
        String inputName=Console.readLine();
        System.out.println("inputName = " + inputName);

        String moveCount = Console.readLine();
        System.out.println("moveCount = " + moveCount);
        return new Object[]{inputName, moveCount};
    }
}
