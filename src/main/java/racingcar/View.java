package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class View {
    private static final String CAR_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public String getCarInput() {
        System.out.println(CAR_PROMPT);
        return Console.readLine().strip();
    }
}
