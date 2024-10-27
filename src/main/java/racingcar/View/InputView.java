package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String InputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int InputTryCounts() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        String input = Console.readLine();

        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (!isNumeric(input) || Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(input);
    }

    private boolean isNumeric(String input) {
        return input.matches("\\d+");
    }
}
