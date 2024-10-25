package racingcar.views;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACE_ATTEMPTS_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static List<String> inputCarNames() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String input = Console.readLine().trim();
        return splitCarNames(input);
    }

    public static List<String> splitCarNames(String input) {
        return Arrays.stream(input.split(",")).toList();
    }

    public static String inputRaceAttempts() {
        System.out.println(RACE_ATTEMPTS_INPUT_MESSAGE);
        return Console.readLine().trim();
    }
}
