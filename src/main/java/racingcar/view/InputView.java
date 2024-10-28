package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ",";
    private static final int MAX_ATTEMPTS = 10;
    private static final int MAX_CAR_COUNT = 5;

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        validateDelimiter(input);

        List<String> carNames = Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());

        validateCarNames(carNames);
        return carNames;
    }

    public int getNumberOfAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        validateIsNumeric(input);

        int attempts = convertToInt(input);
        validateAttemptCount(attempts);
        return attempts;
    }

    public void close() {
        Console.close();
    }

    private int convertToInt(String input) {
        return Integer.parseInt(input);
    }

    private void validateDelimiter(String input) {
        if (input.contains(",,") ) {
            throw new IllegalArgumentException("구분자는 연속으로 사용될 수 없습니다.");
        }

        if (input.startsWith(DELIMITER) || input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException("구분자는 입력의 시작이나 끝에 위치할 수 없습니다.");
        }
    }

    private void validateIsNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("유효한 숫자를 입력해야 합니다.");
        }
    }

    private void validateAttemptCount(int attempts) {
        if (attempts > MAX_ATTEMPTS) {
            throw new IllegalArgumentException("이동 횟수는 최대 10회까지 입력 가능합니다.");
        }
    }

    private void validateCarNames(List<String> carNames) {
        if (carNames.size() > MAX_CAR_COUNT) {
            throw new IllegalArgumentException("자동차 이름은 최대 5개까지 입력 가능합니다.");
        }

        if (carNames.contains("")) {
            throw new IllegalArgumentException("이름값이 비어있습니다.");
        }

        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() < carNames.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }
}