package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public InputView() {
    }

    public String carNamesInput() {
        printCarNamesInputMessage();
        return Console.readLine();
    }

    private void printCarNamesInputMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public String gameRoundInput() {
        printGameRoundInputMessage();
        return Console.readLine();
    }

    private void printGameRoundInputMessage() {
        System.out.println(TRY_INPUT_MESSAGE);
    }
}
