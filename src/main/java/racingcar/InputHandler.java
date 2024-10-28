package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputHandler {

    public List<String> inputCarName() {
        String input = Console.readLine();
        validateInputFormat(input);
        List<String> carNames = parseCarNames(input);
        validateCarNames(carNames);

        return carNames;
    }

    private void validateInputFormat(String input) {
        if (input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException("쉼표(,)로 시작하거나 끝날 수 없습니다.");
        }
        if (input.matches(".*,{2,}.*")) {
            throw new IllegalArgumentException("쉼표(,)가 연속으로 올 수 없습니다.");
        }
    }

    private List<String> parseCarNames(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validateCarNames(List<String> carNames) {
        validateDuplicateNames(carNames);
        validateEachName(carNames);
    }

    private void validateDuplicateNames(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>(carNames);
        if (uniqueCarNames.size() != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private void validateEachName(List<String> carNames) {
        for (String name : carNames) {
            if (name.isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하로 입력해야합니다.");
            }
        }
    }


    public int inputAttemptNumber() {
        String input = Console.readLine().trim();
        int attemptNumber = parseAttemptNumber(input);
        validateAttemptNumber(attemptNumber);

        return attemptNumber;
    }

    private int parseAttemptNumber(String input) {
        validateNumberSize(input);
        return convertToNumber(input);
    }

    private void validateNumberSize(String input) {
        if (input.length() > String.valueOf(Integer.MAX_VALUE).length()) {
            throw new IllegalArgumentException("시도 횟수가 int 범위를 초과했습니다.");
        }
    }

    private int convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야합니다.");
        }
    }

    private void validateAttemptNumber(int attemptNumber) {
        if (attemptNumber <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야합니다.");
        }
    }
}
