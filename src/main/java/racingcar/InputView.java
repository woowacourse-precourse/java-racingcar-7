package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        validateEmpty(input);
        List<String> carNames = Utils.splitByDelimiter(input);
        validateDuplicate(carNames);
        return carNames;
    }

    public static int inputTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String trycount = Console.readLine().trim();
        validateEmpty(trycount);
        validateNumber(trycount);
        return Integer.parseInt(trycount);
    }

    private static void validateEmpty(String input) {
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException("빈 값이 입력되었습니다.");
        }
    }

    private static void validateDuplicate(List<String> names) {
        long nameCount = names.stream()
                .distinct()
                .count();

        if (nameCount != names.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    private static void validateNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("양수를 입력해주세요.");
        }
    }
}
