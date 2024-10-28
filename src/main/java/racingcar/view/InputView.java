package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.TryCountValidator;

public class InputView {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static String inputName() {
        System.out.println(START_MESSAGE);
        return Console.readLine();
    }

    public static int inputTryCount() {
        System.out.println(TRY_COUNT_MESSAGE);
        return TryCountValidator.validateTryCount(Console.readLine());
    }
}
