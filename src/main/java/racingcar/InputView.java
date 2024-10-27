package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = Arrays.asList(input.split(","));
        carNames.forEach(InputView::validateCarName);
        return carNames;
    }

    public static int getRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        validateRounds(input);
        return Integer.parseInt(input);
    }

    private static void validateCarName(String name) {
        if (name.trim().isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateRounds(String rounds) {
        try {
            int parsedRounds = Integer.parseInt(rounds);
            if (parsedRounds < 1) throw new IllegalArgumentException();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
