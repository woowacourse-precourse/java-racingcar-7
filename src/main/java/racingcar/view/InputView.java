package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.InputValidator;
import racingcar.utils.NameParser;

import java.util.List;

public class InputView {
    private static final String REQUEST_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private static final String REQUEST_TOTAL_ROUNDS = "시도할 횟수는 몇 회인가요?";

    public static List<String> getCarNames() {
        requestCarNames();
        return NameParser.parse(Console.readLine());
    }

    public static int getTryCount() {
        requestTryCount();
        String tryCount = Console.readLine();
        return InputValidator.parseAndValidateTryCount(tryCount);
    }

    private static void requestCarNames() {
        System.out.println(REQUEST_CAR_NAMES);
    }

    private static void requestTryCount() {
        System.out.println(REQUEST_TOTAL_ROUNDS);
    }


}
