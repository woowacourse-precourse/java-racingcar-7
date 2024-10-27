package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import racingcar.exception.DuplicatedElementException;
import racingcar.exception.NonPositiveNumberException;

public class RacingCarInputView {

    public static List<String> inputCarNames() {
        List<String> carNames;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        carNames = Arrays.stream(input.split(",")).toList();
        Validator.validateCarNames(carNames);

        return carNames;
    }

    public static int inputTryCount() {
        int tryCount;

        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        tryCount = parseInt(input);
        Validator.validateTryCount(tryCount);

        return tryCount;
    }

    private static int parseInt(String numberStr) {
        int result;

        try {
            result = Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("int형으로 변환할 수 없습니다.");
        }

        return result;
    }

    private static class Validator {

        public static void validateCarNames(List<String> list) {
            try {
                validateDuplicated(list);
            } catch (DuplicatedElementException e) {
                throw new IllegalArgumentException("중복되지 않은 이름으로 입력해주세요.");
            }
        }

        private static void validateTryCount(int tryCount) {
            try {
                validatePositiveNumber(tryCount);
            } catch (NonPositiveNumberException e) {
                throw new IllegalArgumentException("시도 횟수는 양수만을 허용합니다.");
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
