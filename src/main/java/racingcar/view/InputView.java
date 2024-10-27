package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String input(String prompt) {
        System.out.print(prompt);

        return Console.readLine();
    }
}
