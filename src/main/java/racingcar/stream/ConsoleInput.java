package racingcar.stream;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class ConsoleInput {

    public List<String> inputNames() {
        String input = Console.readLine();
        validateNamesInput(input);
        return List.of(input.split(","));
    }

    private void validateNamesInput(String inputNames) {
        if (inputNames == null || inputNames.trim().isEmpty()) {
            throw new IllegalArgumentException("이름 입력이 올바르지 않습니다.");
        }
    }

    public int inputRoundCount() {
        String count = Console.readLine();
        validateCountInput(count);
        return Integer.parseInt(count);
    }

    private void validateCountInput(String count) {
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수 입력이 올바르지 않습니다.");
        }
    }

}
