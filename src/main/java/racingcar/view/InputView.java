package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> names = splitCarNames(input);
        validateCarNames(names);
        return names;
    }

    public List<String> splitCarNames(String input) {
        return Arrays.asList(input.split(","));
    }

    public void validateCarNames(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }
        for (String name : names) {
            validateCarName(name);
        }
    }

    public void validateCarName(String name) {
        String trimmedName = name.trim();
        if (trimmedName.isEmpty() || trimmedName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하이어야 합니다.");
        }
    }

    public int getMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return parseMoveCount(input);
    }

    public int parseMoveCount(String input) {
        int moveCount = convertToInt(input);
        validateMoveCount(moveCount);
        return moveCount;
    }

    public int convertToInt(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException("시도할 횟수는 숫자여야 합니다.");
        }
        return Integer.parseInt(input);
    }

    private boolean isNumeric(String input) {
        return input != null && input.matches("\\d+");
    }

    private void validateMoveCount(int moveCount) {
        if (moveCount <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 1 이상이어야 합니다.");
        }
    }
}