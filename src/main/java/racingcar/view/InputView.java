package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_VIEW = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static String readCarNames() {
        System.out.println(INPUT_VIEW);
        String input = Console.readLine().trim();
        Console.close();

        return input;
    }
}
