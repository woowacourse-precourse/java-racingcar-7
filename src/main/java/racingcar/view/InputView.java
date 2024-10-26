package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INTRODUCE_QUESTION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_QUESTION = "시도할 횟수는 몇 회인가요?";

    public static InputForm input() {
        System.out.println(INTRODUCE_QUESTION);
        String inputNames = Console.readLine();
        System.out.println(ROUND_QUESTION);
        int roundCount = Integer.parseInt(Console.readLine());
        return new InputForm(inputNames, roundCount);
    }
}
