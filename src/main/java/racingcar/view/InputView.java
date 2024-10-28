package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String DELIMITER = ",";

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        validateDelimiter(input);
        return Arrays.asList(input.split(DELIMITER));
    }

    public int getNumberOfAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        validateIsNumeric(input);
        return convertToInt(input);
    }

    public void close() {
        Console.close();
    }

    private void validateDelimiter(String input) {
        if (!input.contains(DELIMITER)) {
            throw new IllegalArgumentException("구분자는 쉼표로 작성해야 합니다.");
        }
    }

    private void validateIsNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("유효한 숫자를 입력해야 합니다.");
        }
    }

    private int convertToInt(String input) {
        return Integer.parseInt(input);
    }
}