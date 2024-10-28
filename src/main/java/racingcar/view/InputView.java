package racingcar.view;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String SEPARATOR = ",";
    private static final String INVALID_CAR_NAME_EXCEPTION_MESSAGE = "자동차 이름은 5자 이하여야 합니다.";
    private static final String INVALID_TRY_COUNT_EXCEPTION_MESSAGE = "시도 횟수는 1회 이상이어야 합니다.";
    private static final String TRY_COUNT_FORMAT_EXCEPTION_MESSAGE = "시도 횟수는 숫자여야 합니다.";

    private String getInput(String message) {
        System.out.println(message);
        return readLine();
    }

    public List<String> getCarNames() {
        return parseCarNames(getInput(CAR_INPUT_MESSAGE));
    }

    public int getTryCount() {
        return parseTryCount(getInput(TRY_COUNT_INPUT_MESSAGE));
    }

    private List<String> parseCarNames(String input) {
        List<String> cars = Arrays.asList(input.split(SEPARATOR));

        validateCarNames(cars);

        return cars;
    }

    private int parseTryCount(String input) {
        validateTryCount(input);
        return Integer.parseInt(input);
    }

    private void validateCarNames(List<String> cars) {
        if (cars.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_EXCEPTION_MESSAGE);
        }
    }

    private void validateTryCount(String input) {
        try {
            if (Integer.parseInt(input) <= 0) {
                throw new IllegalArgumentException(INVALID_TRY_COUNT_EXCEPTION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_COUNT_FORMAT_EXCEPTION_MESSAGE);
        }
    }
}
