package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Winners;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RaceException;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class UIController {

    private static final String QUESTION_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String QUESTION_TRY_COUNT = "시도할 횟수는 몇 회인가요?";
    private static final String RACE_RESULT = "실행 결과";
    private static final String NAME_SEPARATOR_SYMBOL = ",";

    public List<String> receiveName() {
        OutputView.print(QUESTION_CAR_NAME);
        return validateName(InputView.read());
    }

    public int receiveCount() {
        OutputView.print(QUESTION_TRY_COUNT);
        return validateCount(InputView.read());
    }

    public void printRaceResultPhrase() {
        OutputView.print(RACE_RESULT);
    }

    public void printRaceResult(Cars cars) {
        for (Car car : cars.getCars()) {
            OutputView.print(car.toString());
        }
        OutputView.print("");
    }

    public void printWinner(Winners winners) {
        OutputView.print(winners.toString());
    }

    private List<String> validateName(String input) {
        validateBlank(input);
        validateSeparator(input);

        return split(input, NAME_SEPARATOR_SYMBOL);
    }

    private List<String> split(String input, String separator) {
        return Arrays.stream(input.split(separator))
                .toList();
    }

    private void validateBlank(String input) {
        if (isBlank(input)) {
            throw new RaceException(ErrorMessage.INVALID_INPUT_BLANK);
        }
    }

    private boolean isBlank(String input) {
        return input.isBlank();
    }

    private void validateSeparator(String input) {
        validateEdgeSeparator(input);
        validateContinuousSeparator(input);
    }

    private void validateEdgeSeparator(String input) {
        if (isEdgeSeparator(input)) {
            throw new RaceException(ErrorMessage.INVALID_INPUT_FORMAT);
        }
    }

    private boolean isEdgeSeparator(String input) {
        return input.startsWith(NAME_SEPARATOR_SYMBOL) || input.endsWith(NAME_SEPARATOR_SYMBOL);
    }

    private void validateContinuousSeparator(String input) {
        if (isContinuousSeparator(input)) {
            throw new RaceException(ErrorMessage.INVALID_CONTINUOUS_SEPARATOR);
        }
    }

    private boolean isContinuousSeparator(String input) {
        return input.contains(NAME_SEPARATOR_SYMBOL.repeat(2));
    }

    private int validateCount(String count) {
        validateBlank(count);
        return validateNumber(count);
    }

    private int validateNumber(String count) {
        if (isNotPositiveInteger(count)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COUNT_FORMAT.getMessage());
        }
        return Integer.parseInt(count);
    }

    private boolean isNotPositiveInteger(String count) {
        return !count.matches("^[1-9]*$");
    }
}
