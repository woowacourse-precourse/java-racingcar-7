package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String ERROR_INVALID_DELIMITER_MESSAGE = "구분자는 처음과 끝에 존재할 수 없습니다.";
    private static final String ERROR_INVALID_TRY_COUNT_MESSAGE = "시도 횟수는 양수여야 합니다.";
    private static final String DELIMITER = ",";
    private static final int MIN_TRY_COUNT = 1;

    public static List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String carNames = Console.readLine();
        validateCarNames(carNames);

        return Arrays.stream(carNames.split(DELIMITER)).toList();
    }

    private static void validateCarNames(String carNames) {
        if (carNames.startsWith(DELIMITER) || carNames.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(ERROR_INVALID_DELIMITER_MESSAGE);
        }
    }

    public static int inputTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        int tryCount = Integer.parseInt(Console.readLine());
        validateTryCount(tryCount);

        return tryCount;
    }

    private static void validateTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException(ERROR_INVALID_TRY_COUNT_MESSAGE);
        }
    }
}
