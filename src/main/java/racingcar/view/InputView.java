package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_NUMBER = "시도할 횟수는 몇 회인가요?";

    public String inputString() {
        System.out.println(INPUT_TEXT);
        return Console.readLine();
    }

    public String inputNumber() {
        System.out.println(INPUT_NUMBER);
        return Console.readLine();
    }
}

