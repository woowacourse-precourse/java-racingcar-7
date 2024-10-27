package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 반드시 입력해야 합니다.");
        }
        return input;
    }

    public int getUserInputAsInt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        System.out.println();

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("이동 횟수를 반드시 입력해야 합니다.");
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력해야 합니다.");
        }
    }
}