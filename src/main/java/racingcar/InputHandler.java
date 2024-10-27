package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {

    public List<String> inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = parseCarNames(input);
        validateCarNames(carNames);

        return carNames;
    }

    private List<String> parseCarNames(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하로 입력해야 합니다.");
            }
        }
    }


    public int inputAttemptNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        int attemptNumber = parseAttemptNumber(input);
        validateAttemptNumber(attemptNumber);

        return attemptNumber;
    }

    private int parseAttemptNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 숫자여야 합니다.");
        }
    }

    private void validateAttemptNumber(int attemptNumber) {
        if (attemptNumber <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 숫자여야 합니다.");
        }
    }
}
