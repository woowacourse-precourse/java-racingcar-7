package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Arrays;

public class InputReader {
    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        validateEmptyCarName(input);
        return parseCarNames(input);
    }

    private void validateEmptyCarName(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
    }

    private void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
        if (name.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에는 공백을 포함할 수 없습니다.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
    }

    private List<String> parseCarNames(String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        if (carNames.size() <= 1) {
            throw new IllegalArgumentException("2대 이상의 차량을 입력해야 합니다.");
        }

        carNames.forEach(this::validateCarName);
        return carNames;
    }
}
