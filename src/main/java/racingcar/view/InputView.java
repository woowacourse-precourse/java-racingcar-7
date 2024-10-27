package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_NAME_STRING = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TIMES_STRING = "시도할 횟수는 몇 회인가요?";

    public String inputName() {
        System.out.println(INPUT_NAME_STRING);
        return Console.readLine();
    }
}