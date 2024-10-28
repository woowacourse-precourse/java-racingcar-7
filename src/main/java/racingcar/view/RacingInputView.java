package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.global.Symbol;

public class RacingInputView {

    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 %s(%s) 기준으로 구분)";
    private static final String COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public String requestNamesInput() {
        System.out.println(Symbol.NAME_DELIMITER
                .formatMessageOf(NAME_INPUT_MESSAGE)
        );

        return Console.readLine();
    }

    public String requestCountInput() {
        System.out.println(COUNT_INPUT_MESSAGE);

        return Console.readLine();
    }
}