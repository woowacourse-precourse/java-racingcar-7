package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class RacingGame {
    public void start() {
        List<String> carNames = getCarNames();
        int attempts = getAttempts();

        Race race = new Race(carNames);
        race.run(attempts);
    }

    private List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = Arrays.asList(input.split(","));
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해 주세요.");
        }
        return carNames;
    }

    private int getAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력해 주세요.");
        }
    }
}
