package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ENTER_CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ENTER_TRY_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?";

    public static String inputCarNames() {
        System.out.println(ENTER_CAR_NAMES_PROMPT);
        return Console.readLine();
    }

    public static String inputTryCount() {
        System.out.println(ENTER_TRY_COUNT_PROMPT);
        return Console.readLine();
    }
}
