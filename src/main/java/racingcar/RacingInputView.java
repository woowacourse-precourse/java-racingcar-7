package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingInputView {
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MOVE_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private String Input;

    public String getCarNamesInput() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        Input = Console.readLine();
        return Input;
    }

    public String getMoveCount() {
        System.out.println(MOVE_COUNT_INPUT_MESSAGE);
        Input = Console.readLine();
        return Input;
    }
}
