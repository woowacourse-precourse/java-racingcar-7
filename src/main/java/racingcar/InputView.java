package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static final String LINE_SEPARATOR = System.lineSeparator(); // 개행

    public List<String> enterCarNames() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        System.out.print(LINE_SEPARATOR);
        String userInput = Console.readLine();

        List<String> carNames = parseCarNames(userInput);
        validateCarNames(carNames);
        return carNames;
    }

    private List<String> parseCarNames(String carNames) {
        return Arrays.stream(carNames.split(","))
                .toList();
    }

    private void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            validateCarNameLength(carName);
        }
        validateDuplicates(carNames);
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() < 1 || carName.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 1글자 이상 5글자 이하만 가능합니다.");
        }
    }

    private void validateDuplicates(List<String> carNames) {
        if (carNames.stream()
                .distinct()
                .count() != carNames.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }

    public int enterRoundCount() {
        System.out.print("시도할 횟수는 몇 회인가요?");
        System.out.print(LINE_SEPARATOR);
        String userInput = Console.readLine();
        validateRoundCount(userInput);

        int roundCount = Integer.parseInt(userInput);
        return roundCount;
    }

    private void validateRoundCount(String userInput) {
        validateInteger(userInput);
        int roundCount = Integer.parseInt(userInput);
        validateRoundCountRange(roundCount);
    }

    private void validateInteger(String maybeInteger) {
        try {
            Integer.parseInt(maybeInteger);
        } catch (Exception e) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }
    }

    private void validateRoundCountRange(int roundCount) {
        if (roundCount < 0 || roundCount > 100_0000) {
            throw new IllegalArgumentException("1이상 100만 이하의 숫자를 입력해주세요.");
        }
    }
}
