package racingcar.view;

import java.util.Arrays;
import java.util.List;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RaceException;
import racingcar.view.console.Reader;
import racingcar.view.console.Writer;

public class InputView {

    private static final String QUESTION_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String QUESTION_TRY_COUNT = "시도할 횟수는 몇 회인가요?";
    private static final String NAME_SEPARATOR_SYMBOL = ",";
    private static final String INTEGER_PATTERN = "^[1-9]*$";
    private static final int CONTINUOUS_THRESHOLD = 2;

    public List<String> receiveName() {
        Writer.print(QUESTION_CAR_NAME);
        return Validator.validateName(Reader.read());
    }

    public int receiveCount() {
        Writer.print(QUESTION_TRY_COUNT);
        return Validator.validateCount(Reader.read());
    }

    private static class Validator {

        private static List<String> validateName(String input) {
            validateSeparator(input);
            return split(input, NAME_SEPARATOR_SYMBOL);
        }

        private static List<String> split(String input, String separator) {
            return Arrays.stream(input.split(separator))
                    .toList();
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
            return input.contains(NAME_SEPARATOR_SYMBOL.repeat(CONTINUOUS_THRESHOLD));
        }

        private static int validateCount(String count) {
            return validateNumber(count);
        }

        private static int validateNumber(String count) {
            if (isNotPositiveInteger(count)) {
                throw new RaceException(ErrorMessage.INVALID_COUNT_FORMAT);
            }
            return Integer.parseInt(count);
        }

        private static boolean isNotPositiveInteger(String count) {
            return !count.matches(INTEGER_PATTERN);
        }
    }
}
