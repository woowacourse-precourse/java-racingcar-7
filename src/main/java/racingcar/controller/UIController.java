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
    private static final String EMPTY = "";
    private static final String INTEGER_PATTERN = "^[1-9]*$";
    private static final int TWO = 2;

    public List<String> receiveName() {
        OutputView.print(QUESTION_CAR_NAME);
        return Validator.validateName(InputView.read());
    }

    public int receiveCount() {
        OutputView.print(QUESTION_TRY_COUNT);
        return Validator.validateCount(InputView.read());
    }

    public void printRaceResultPhrase() {
        OutputView.print(RACE_RESULT);
    }

    public void printRaceResult(Cars cars) {
        for (Car car : cars.getCars()) {
            OutputView.print(car.toString());
        }
        OutputView.print(EMPTY);
    }

    public void printWinner(Winners winners) {
        OutputView.print(winners.toString());
    }

    private static class Validator {

        private static List<String> validateName(String input) {
            validateBlank(input);
            validateSeparator(input);

            return split(input, NAME_SEPARATOR_SYMBOL);
        }

        private static List<String> split(String input, String separator) {
            return Arrays.stream(input.split(separator))
                    .toList();
        }

        private static void validateBlank(String input) {
            if (isBlank(input)) {
                throw new RaceException(ErrorMessage.INVALID_INPUT_BLANK);
            }
        }

        private static boolean isBlank(String input) {
            return input.isBlank();
        }

        private static void validateSeparator(String input) {
            validateEdgeSeparator(input);
            validateContinuousSeparator(input);
        }

        private static void validateEdgeSeparator(String input) {
            if (isEdgeSeparator(input)) {
                throw new RaceException(ErrorMessage.INVALID_INPUT_FORMAT);
            }
        }

        private static boolean isEdgeSeparator(String input) {
            return input.startsWith(NAME_SEPARATOR_SYMBOL) || input.endsWith(NAME_SEPARATOR_SYMBOL);
        }

        private static void validateContinuousSeparator(String input) {
            if (isContinuousSeparator(input)) {
                throw new RaceException(ErrorMessage.INVALID_CONTINUOUS_SEPARATOR);
            }
        }

        private static boolean isContinuousSeparator(String input) {
            return input.contains(NAME_SEPARATOR_SYMBOL.repeat(TWO));
        }

        private static int validateCount(String count) {
            validateBlank(count);
            return validateNumber(count);
        }

        private static int validateNumber(String count) {
            if (isNotPositiveInteger(count)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_COUNT_FORMAT.getMessage());
            }
            return Integer.parseInt(count);
        }

        private static boolean isNotPositiveInteger(String count) {
            return !count.matches(INTEGER_PATTERN);
        }
    }
}
