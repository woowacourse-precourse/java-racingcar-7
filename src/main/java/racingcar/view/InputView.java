package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;

public class InputView {

    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "숫자를 입력해주세요.";
    private static final String READ_CARS_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String READ_ATTEMPT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String CARS_INPUT_DELIMITER = ",";

    public List<String> readCars() {
        System.out.println(READ_CARS_MESSAGE);
        String input = readLine();
        return Stream.of(input.split(CARS_INPUT_DELIMITER))
                .map(String::trim)
                .toList();
    }

    public int readAttemptCount() {
        System.out.println(READ_ATTEMPT_COUNT_MESSAGE);
        String input = readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    private String readLine() {
        return Console.readLine().trim();
    }
}
