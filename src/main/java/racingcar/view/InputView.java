package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String ROUND_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public void printCarNameInputMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public void printRoundCountInputMessage() {
        System.out.println(ROUND_COUNT_INPUT_MESSAGE);
    }

    public String getInput() {
        return Console.readLine();
    }
}
