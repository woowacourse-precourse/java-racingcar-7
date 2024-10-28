package racingcar.views;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static String inputString() {
        System.out.println(INPUT_MSG);
        return Console.readLine();
    }
}
