package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import racingcar.exception.DuplicatedCarNameException;
import racingcar.exception.DuplicatedElementException;
import racingcar.exception.NonParsableIntegerException;
import racingcar.exception.NonPositiveNumberException;
import racingcar.exception.NonPositiveTryCountException;

public class RacingCarInputView {

    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static List<String> inputCarNames() {
        List<String> carNames;

        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        String input = Console.readLine();

        carNames = parseCarNames(input);

        return carNames;
    }

    public static int inputTryCount() {
        int tryCount;

        System.out.println(TRY_COUNT_INPUT_MESSAGE);
        String input = Console.readLine();

        tryCount = parseTryCount(input);

        return tryCount;
    }

    private static List<String> parseCarNames(String input) {
        List<String> carNames;

        carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        Validator.validateCarNames(carNames);

        return carNames;
    }

    private static int parseTryCount(String tryCountInput) {
        int tryCount;

        try {
            tryCount = Integer.parseInt(tryCountInput);
        } catch (NumberFormatException e) {
            throw new NonParsableIntegerException();
        }

        Validator.validateTryCount(tryCount);

        return tryCount;
    }

    private static class Validator {

        public static void validateCarNames(List<String> list) {
            try {
                validateDuplicated(list);
            } catch (DuplicatedElementException e) {
                throw new DuplicatedCarNameException();
            }
        }

        public static void validateTryCount(int tryCount) {
            try {
                validatePositiveNumber(tryCount);
            } catch (NonPositiveNumberException e) {
                throw new NonPositiveTryCountException();
            }
        }

        private static void validateDuplicated(Collection<?> collection) {
            if (collection.size() != new HashSet<>(collection).size()) {
                throw new DuplicatedElementException();
            }
        }

        private static void validatePositiveNumber(int number) {
            if (number <= 0) {
                throw new NonPositiveNumberException();
            }
        }
    }
}
