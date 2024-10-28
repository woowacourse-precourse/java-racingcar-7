package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String[] readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        validateInput(input);
        return input.split(",");
    }

    private void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        if (input.endsWith(",") || input.startsWith(",")) {
            throw new IllegalArgumentException("쉼표 앞뒤에 자동차 이름이 있어야 합니다.");
        }
        if (input.contains(",,")) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
    }

    public int readRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        validateRounds(input);
        return Integer.parseInt(input);
    }

    private void validateRounds(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("시도 횟수를 입력해주세요.");
        }
        try {
            int rounds = Integer.parseInt(input);
            if (rounds <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
    }
}