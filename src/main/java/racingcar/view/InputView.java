package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUNDS_PROMPT = "시도할 횟수는 몇 회인가요?";

    private InputView() {
    }

    public static String getCarNames() {
        System.out.println(CAR_NAMES_PROMPT);
        return Console.readLine();
    }

    public static String getRounds() {
        System.out.println(ROUNDS_PROMPT);
        return Console.readLine();
    }
}
