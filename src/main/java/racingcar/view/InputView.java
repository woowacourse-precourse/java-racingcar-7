package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.utils.Validator.validateAttemptCount;
import static racingcar.utils.Validator.validateCarNames;

import java.util.List;

public class InputView {
    private static final String CAR_NAMES_INPUT_GUIDE_PHRASE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NUMBER_OF_ATTEMPTS_INPUT_GUIDE_PHRASE = "시도할 횟수는 몇 회인가요?";

    public static List<String> getCarNames() {
        System.out.println(CAR_NAMES_INPUT_GUIDE_PHRASE);
        return validateCarNames(readLine());
    }

    public static int getNumberOfAttempts() {
        System.out.println(NUMBER_OF_ATTEMPTS_INPUT_GUIDE_PHRASE);
        return validateAttemptCount(readLine());
    }
}
