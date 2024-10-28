package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public static List<String> promptForCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return List.of(Console.readLine().split(","));
    }

    public static int promptForTotalRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return parseInputToInt(Console.readLine());
    }

    private static int parseInputToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수는 정수로 입력해야 합니다.");
        }
    }
}
