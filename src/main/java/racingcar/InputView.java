package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRIAL_COUNT = "시도할 회수는 몇회인가요?";
    private static final String POSITIVE_NUMBER_PATTERN = "\\d+";
    private static final String EMPTY_INPUT_ERROR = "빈 값이 입력되었습니다.";
    private static final String DUPLICATE_NAME_ERROR = "중복된 이름이 있습니다.";
    private static final String POSITIVE_NUMBER_ERROR = "양수를 입력해주세요.";

    public static List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAME);
        String input = Console.readLine();
        validateEmpty(input);
        List<String> carNames = Utils.splitByDelimiter(input);
        validateDuplicate(carNames);
        return carNames;
    }

    public static int inputTryCount() {
        System.out.println(INPUT_TRIAL_COUNT);
        String trycount = Console.readLine().trim();
        validateEmpty(trycount);
        validateNumber(trycount);
        return Integer.parseInt(trycount);
    }

    private static void validateEmpty(String input) {
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }
    }

    private static void validateDuplicate(List<String> names) {
        long nameCount = names.stream()
                .distinct()
                .count();

        if (nameCount != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR);
        }
    }

    private static void validateNumber(String input) {
        if (!input.matches(POSITIVE_NUMBER_PATTERN)) {
            throw new IllegalArgumentException(POSITIVE_NUMBER_ERROR);
        }
    }
}
