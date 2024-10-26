package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class RacingView {

    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public String requestNamesInput() {
        System.out.println(NAME_INPUT_MESSAGE);

        return Console.readLine();
    }
}