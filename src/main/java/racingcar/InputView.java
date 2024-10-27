package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static final String LINE_SEPARATOR = System.lineSeparator(); // 개행

    public List<String> enterCarNames() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        System.out.print(LINE_SEPARATOR);
        String input = Console.readLine();
        return parseCarNames(input);
    }

    public int enterRoundCount() {
        System.out.print("시도할 횟수는 몇 회인가요?");
        System.out.print(LINE_SEPARATOR);
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    private List<String> parseCarNames(String carNames) {
        return Arrays.stream(carNames.split(","))
                .toList();
    }
}
