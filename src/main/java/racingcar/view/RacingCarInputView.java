package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
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
        try {
            Validator.validateDuplicated(carNames);
        } catch (DuplicatedElementException e) {
            throw new IllegalArgumentException("중복되지 않은 이름으로 입력해주세요.");
        }

        return carNames;
    }

    public static int inputTryCount() {
        int tryCount;

        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        try {
            tryCount = Integer.parseInt(input);
            Validator.validatePositiveNumber(tryCount);
        } catch (NumberFormatException | NonPositiveNumberException e) {
            throw new IllegalArgumentException("int형 범위의 양수를 입력해주세요.");
        }

        return tryCount;
    }

    private static class Validator {

        private static void validateDuplicated(List<String> list) {
            if (list.size() != new HashSet<>(list).size()) {
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
